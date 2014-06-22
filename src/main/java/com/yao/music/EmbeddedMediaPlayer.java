package com.yao.music;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.net.URLEncoder;

/**
 * Created by 世宁 on 2014/6/22 0022.
 */
public class EmbeddedMediaPlayer extends Application {
    private static final String MEDIA_URL = "file:///E:/Music/英语/Coldplay/Parachutes/Yellow.mp3";
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Embedded Media Player");
        Group root = new Group();
        Scene scene = new Scene(root,540,210);
        stage.setScene(scene);
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().add(mediaView);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
