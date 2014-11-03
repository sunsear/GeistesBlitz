/**
 * Your application code goes here
 */
package userclasses;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import eu.van_dijken.geistesblitz.engine.CardImage;
import eu.van_dijken.geistesblitz.engine.GeistesBlitz;
import eu.van_dijken.geistesblitz.engine.ItemColor;
import eu.van_dijken.geistesblitz.engine.Player;
import generated.StateMachineBase;

public class StateMachine extends StateMachineBase {

    private GeistesBlitz game;

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
    }

    @Override
    protected void onCreateMain() {

    }

    @Override
    protected void onMain_StartGameButtonAction(Component c, ActionEvent event) {
        game = new GeistesBlitz();
        showForm("EnterUserScreen", null);
    }

    @Override
    protected void onEnterUserScreen_EnterUserNamesButtonAction(Component c, ActionEvent event) {
        game.addPlayer(findPlayer1TextField().getText());
        game.addPlayer(findPlayer2TextField().getText());
        game.start();
        createGameScreen();
    }

    private void createGameScreen() {
        Resources resources = fetchResourceFile();
        Form gameUI = new Form();
        game.round();
        gameUI.setLayout(new BorderLayout());

        PlayerUI player1UI = new PlayerUI(resources, 1);
        gameUI.addComponent(BorderLayout.NORTH, player1UI.playerContainer);
        PlayerUI player0UI = new PlayerUI(resources, 0);
        gameUI.addComponent(BorderLayout.SOUTH, player0UI.playerContainer);

        player0UI.nextRoundButton.addActionListener(new NextRoundListener(resources, player0UI, player1UI));
        player1UI.nextRoundButton.addActionListener(new NextRoundListener(resources, player0UI, player1UI));
        player0UI.finishGameButton.addActionListener(new FinishGameListener(resources));
        player1UI.finishGameButton.addActionListener(new FinishGameListener(resources));

        gameUI.show();
    }

    private ImageViewer showCardImage(Resources resources, int imageIndex, int playerIndex) {
        CardImage cardImage = game.shownCard().images().get(imageIndex);
        Image image = resources.getImage(cardImage.getColor().name() + cardImage.getType().name() + ".png");
        return new ImageViewer(playerIndex == 0 ? image : image.rotate180Degrees(true));
    }

    private void createPlayerSolutionButton(Resources resources, Container buttonContainer, ItemColor color,
                                            eu.van_dijken.geistesblitz.engine.ItemType type, int playerIndex) {
        eu.van_dijken.geistesblitz.engine.Item item = new eu.van_dijken.geistesblitz.engine.Item(color, type);
        Image image = resources.getImage(item.getColor().name() + item.getType().name() + ".png");

        Button itemButton = new Button(playerIndex == 0 ? image : image.rotate180Degrees(true));
        itemButton.setName(item.getType().name() + "Button");
        itemButton.setUIID("ItemIconButton");
        itemButton.addActionListener(new SolutionButtonListener(playerIndex, item));
        buttonContainer.addComponent(itemButton);
    }

    private class SolutionButtonListener implements ActionListener {
        private int playerIndex;
        private eu.van_dijken.geistesblitz.engine.Item item;

        SolutionButtonListener(int playerIndex, eu.van_dijken.geistesblitz.engine.Item chosen) {
            this.playerIndex = playerIndex;
            this.item = chosen;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            game.provideSolution(playerIndex, item);
        }
    }

    private class NextRoundListener implements ActionListener {
        private final Resources resources;
        private PlayerUI player0UI;
        private PlayerUI player1UI;

        public NextRoundListener(Resources resources, PlayerUI player0UI, PlayerUI player1UI) {

            this.resources = resources;
            this.player0UI = player0UI;
            this.player1UI = player1UI;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            game.finishRound();
            game.round();
            CardImage cardImage = game.shownCard().images().get(0);
            String imageName = cardImage.getColor().name() + cardImage.getType().name() + ".png";
            player0UI.setCardImage1(imageName);
            player1UI.setCardImage1(imageName);
            CardImage cardImage2 = game.shownCard().images().get(1);
            String imageName2 = cardImage2.getColor().name() + cardImage2.getType().name() + ".png";
            player0UI.setCardImage2(imageName2);
            player1UI.setCardImage2(imageName2);
            player0UI.playerScore.setText(game.getPlayer(0).getWonCards().size() + "");
            player1UI.playerScore.setText(game.getPlayer(1).getWonCards().size() + "");

        }
    }

    private class PlayerUI {
        Container playerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        private final ImageViewer cardImage1Viewer;
        private final ImageViewer cardImage2Viewer;
        private final Label playerScore;
        private final Button nextRoundButton;
        private final Button finishGameButton;
        private Resources resources;
        private int playerIndex;

        public PlayerUI(Resources resources, int playerIndex) {
            this.resources = resources;
            this.playerIndex = playerIndex;
            Container cardContainer = new Container(new FlowLayout(Component.CENTER));

            cardImage1Viewer = showCardImage(resources, 0, playerIndex);
            cardContainer.addComponent(cardImage1Viewer);
            cardImage2Viewer = showCardImage(resources, 1, playerIndex);
            cardContainer.addComponent(cardImage2Viewer);

            Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            for (eu.van_dijken.geistesblitz.engine.Item item : game.getItems()) {
                createPlayerSolutionButton(resources, buttonContainer, item.getColor(), item.getType(), playerIndex);
            }
            Container gameStatus = new Container(new FlowLayout(Component.LEFT));
            Label playerName = new Label();
            playerName.setText(game.getPlayer(playerIndex).getName());
            gameStatus.addComponent(playerName);
            playerScore = new Label();
            playerScore.setText(game.getPlayer(playerIndex).getWonCards().size() + "");
            gameStatus.addComponent(playerScore);
            nextRoundButton = new Button();
            nextRoundButton.setText("Next Round");
            gameStatus.addComponent(nextRoundButton);
            finishGameButton = new Button();
            finishGameButton.setText("Finish game");
            gameStatus.addComponent(finishGameButton);

            if (playerIndex == 0) {
                playerContainer.addComponent(gameStatus);
                playerContainer.addComponent(cardContainer);
                playerContainer.addComponent(buttonContainer);
            } else {
                playerContainer.addComponent(buttonContainer);
                playerContainer.addComponent(cardContainer);
                playerContainer.addComponent(gameStatus);
            }
        }

        void setCardImage1(String imageName) {
            Image image = resources.getImage(imageName);
            cardImage1Viewer.setImage(playerIndex == 0 ? image : image.rotate180Degrees(true));
        }

        void setCardImage2(String imageName) {
            Image image = resources.getImage(imageName);
            cardImage2Viewer.setImage(playerIndex == 0 ? image : image.rotate180Degrees(true));
        }
    }

    private class FinishGameListener implements ActionListener {
        private Resources resources;

        public FinishGameListener(Resources resources) {
            this.resources = resources;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            game.finish();
            showForm("FinishGameScreen", null);
        }
    }

    @Override
    protected void beforeFinishGameScreen(Form f) {
        Player winner = game.getWinner();
        if (winner != null) {
            findWinningPlayerNameLabel().setText(winner.getName());
        } else {
            findWinningPlayerNameLabel().setText("No winner :-(");
        }
    }

    @Override
    protected void onFinishGameScreen_StartGameButtonAction(Component c, ActionEvent event) {
        onMain_StartGameButtonAction(c, event);
    }
}
