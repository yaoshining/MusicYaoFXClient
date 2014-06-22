package com.yao.music.controller;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Window;

import java.util.*;

/**
 * Created by 世宁 on 2014/6/22 0022.
 */
public class MusicPlayerController {
    @FXML
    private ListView listView;
    @FXML
    private Button playButton;
    @FXML
    private BorderPane root;
    private MediaPlayer mediaPlayer;
    private static final String MEDIA_URL = "file:///E:/Music/英语/Coldplay/Parachutes/Yellow.mp3";
    private boolean atEndOfMedia = false;
    private double ox;
    private double oy;
    @FXML
    public void play(){
        if(mediaPlayer==null){
            Media media = new Media(MEDIA_URL);
            mediaPlayer = new MediaPlayer(media);
        }
        Status status = mediaPlayer.getStatus();
        System.out.println(status);
        if(status == Status.UNKNOWN || status == Status.HALTED){
            return;
        }
        if(status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
            if (atEndOfMedia) {
                mediaPlayer.seek(mediaPlayer.getStartTime());
                atEndOfMedia = false;
            }
            mediaPlayer.play();
            playButton.setText("暂停");
        } else {
            mediaPlayer.pause();
            playButton.setText("播放");
        }
//        playButton.setVisible(false);
//        pauseButton.setVisible(true);
    }
    @FXML
    public ObservableList<String> initMusicList(){
        List<String> list = new ArrayList<String>();
        list.add("asdad");
        ObservableList<String> musicList = new ObservableListWrapper<String>(list);
        return musicList;
    }
    @FXML
    public void onMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double dx = x-ox;
        double dy = y-oy;
        System.out.println(dx);
        System.out.println(dy);
        ox = x;
        oy = y;
        Window window = root.getScene().getWindow();
        window.setX(window.getX()+dx);
        window.setY(window.getY()+dy);
    }
    public void onMousePressed(MouseEvent event){
        ox = event.getX();
        oy = event.getY();
    }
    @FXML
    public void closePlayer(){
        Platform.exit();
    }
    @FXML
    public void maximum(){

    }

}