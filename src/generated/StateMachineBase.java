/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Main";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Button findStartGameButton(Component root) {
        return (com.codename1.ui.Button)findByName("StartGameButton", root);
    }

    public com.codename1.ui.Button findStartGameButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("StartGameButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("StartGameButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findWinningPlayerNameLabel(Component root) {
        return (com.codename1.ui.Label)findByName("WinningPlayerNameLabel", root);
    }

    public com.codename1.ui.Label findWinningPlayerNameLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("WinningPlayerNameLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("WinningPlayerNameLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findEnterUserNamesButton(Component root) {
        return (com.codename1.ui.Button)findByName("EnterUserNamesButton", root);
    }

    public com.codename1.ui.Button findEnterUserNamesButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("EnterUserNamesButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("EnterUserNamesButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPlayer1TextField(Component root) {
        return (com.codename1.ui.TextField)findByName("Player1TextField", root);
    }

    public com.codename1.ui.TextField findPlayer1TextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Player1TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Player1TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPlayer2TextField(Component root) {
        return (com.codename1.ui.TextField)findByName("Player2TextField", root);
    }

    public com.codename1.ui.TextField findPlayer2TextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Player2TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Player2TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(f.getName())) {
            exitFinishGameScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(f.getName())) {
            exitEnterUserScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitMain(Form f) {
    }


    protected void exitFinishGameScreen(Form f) {
    }


    protected void exitEnterUserScreen(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(f.getName())) {
            beforeFinishGameScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(f.getName())) {
            beforeEnterUserScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeMain(Form f) {
    }


    protected void beforeFinishGameScreen(Form f) {
    }


    protected void beforeEnterUserScreen(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(c.getName())) {
            beforeContainerFinishGameScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(c.getName())) {
            beforeContainerEnterUserScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerFinishGameScreen(Container c) {
    }


    protected void beforeContainerEnterUserScreen(Container c) {
    }

    protected void postShow(Form f) {
        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(f.getName())) {
            postFinishGameScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(f.getName())) {
            postEnterUserScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postMain(Form f) {
    }


    protected void postFinishGameScreen(Form f) {
    }


    protected void postEnterUserScreen(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(c.getName())) {
            postContainerFinishGameScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(c.getName())) {
            postContainerEnterUserScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerFinishGameScreen(Container c) {
    }


    protected void postContainerEnterUserScreen(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(rootName)) {
            onCreateFinishGameScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(rootName)) {
            onCreateEnterUserScreen();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateMain() {
    }


    protected void onCreateFinishGameScreen() {
    }


    protected void onCreateEnterUserScreen() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("FinishGameScreen".equals(f.getName())) {
            getStateFinishGameScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("EnterUserScreen".equals(f.getName())) {
            getStateEnterUserScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateMain(Form f, Hashtable h) {
    }


    protected void getStateFinishGameScreen(Form f, Hashtable h) {
    }


    protected void getStateEnterUserScreen(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("FinishGameScreen".equals(f.getName())) {
            setStateFinishGameScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("EnterUserScreen".equals(f.getName())) {
            setStateEnterUserScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateMain(Form f, Hashtable state) {
    }


    protected void setStateFinishGameScreen(Form f, Hashtable state) {
    }


    protected void setStateEnterUserScreen(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main")) {
            if("StartGameButton".equals(c.getName())) {
                onMain_StartGameButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("FinishGameScreen")) {
            if("StartGameButton".equals(c.getName())) {
                onFinishGameScreen_StartGameButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("EnterUserScreen")) {
            if("Player1TextField".equals(c.getName())) {
                onEnterUserScreen_Player1TextFieldAction(c, event);
                return;
            }
            if("Player2TextField".equals(c.getName())) {
                onEnterUserScreen_Player2TextFieldAction(c, event);
                return;
            }
            if("EnterUserNamesButton".equals(c.getName())) {
                onEnterUserScreen_EnterUserNamesButtonAction(c, event);
                return;
            }
        }
    }

      protected void onMain_StartGameButtonAction(Component c, ActionEvent event) {
      }

      protected void onFinishGameScreen_StartGameButtonAction(Component c, ActionEvent event) {
      }

      protected void onEnterUserScreen_Player1TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onEnterUserScreen_Player2TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onEnterUserScreen_EnterUserNamesButtonAction(Component c, ActionEvent event) {
      }

}
