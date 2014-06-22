package com.yao.music;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * Created by 世宁 on 2014/6/16 0016.
 */
public class MusicPlayer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/player.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
//        Media media = new Media("file:///E:/Music/英语/Coldplay/Parachutes/Yellow.mp3");
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//        MediaView mediaView = new MediaView(mediaPlayer);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(true);
        stage.show();
    }
}
