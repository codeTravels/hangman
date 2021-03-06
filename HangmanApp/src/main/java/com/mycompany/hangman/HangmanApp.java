package com.mycompany.hangman;

import com.mycompany.hangman.actions.ActionManager;
import com.mycompany.hangman.actions.ConfigAction;
import com.mycompany.hangman.actions.ExitAction;
import com.mycompany.hangman.actions.NewGameAction;
import com.mycompany.hangman.controller.ConfigController;
import com.mycompany.hangman.controller.WordController;
import com.mycompany.hangman.gui.ConfigPanel;
import com.mycompany.hangman.gui.GameOverView;
import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.menu.GameMenu;
import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGameImpl;
import com.mycompany.hangman.model.WordGenerator;
import javax.swing.JMenuBar;

/**
 * This class wires up all the components to start the game.
 *
 * @author Cory
 */
public class HangmanApp
{

    public HangmanApp()
    {

    }

    /**
     * This wires up and starts the game.
     */
    public void start()
    {

        HangmanFrame mainFrame = new HangmanFrame();
        HangmanGameImpl game = new HangmanGameImpl(new WordGenerator());
        WordController controller;
        {
            controller = new WordController(mainFrame.getGamePanel(), game);
            controller.addView(mainFrame.getGamePanel().getDrawPanel());
            mainFrame.getGamePanel().addController(controller);
        }

        {
            GameOverView gov = new GameOverView(mainFrame, controller);
            controller.addView(gov);
        }

        ConfigController configController;
        {
            ConfigPanel configPanel = new ConfigPanel(mainFrame);
            configController = new ConfigController(configPanel, game);
            configController.addModel(game);
            configController.addView(configPanel);
            configPanel.setListener(configController);
        }

        ActionManager actionRepo = ActionManager.getInstance();
        {
            actionRepo.put(ActionManager.NEW_GAME_ACTION, new NewGameAction(controller));
            actionRepo.put(ActionManager.CONFIG_GAME_ACTION, new ConfigAction(configController));
            actionRepo.put(ActionManager.EXIT_GAME_ACTION, new ExitAction());
        }

        {
            JMenuBar menuBar = new JMenuBar();
            menuBar.add(new GameMenu(actionRepo.getMapping()));
            mainFrame.setJMenuBar(menuBar);
            mainFrame.pack();
        }

        game.start(new GameConfig());
        mainFrame.setVisible(true);
    }

}
