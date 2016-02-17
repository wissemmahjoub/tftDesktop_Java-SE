/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.ressources.TFTEffects;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author Mustapha
 */
public class TFTTransition {
    
    public static void fadeIn(Node graphic, double duree)
    {
          Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO,
				new KeyValue(graphic.opacityProperty(),0)
					),
                    new KeyFrame(Duration.millis(duree),
				new KeyValue(graphic.opacityProperty(), 1)
					)
                    );
                    timeLine.play();
    }
    public static void fadeOut(Node graphic, double duree)
    {
          Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO,
				new KeyValue(graphic.opacityProperty(),1)
					),
                    new KeyFrame(Duration.millis(duree),
				new KeyValue(graphic.opacityProperty(), 0)
					)
                    );
                    timeLine.play();
    }
    
    
    
    public static void fadeOutAndGoX(Node graphic, double duree)
    {
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO,
				new KeyValue(graphic.opacityProperty(),1),
				new KeyValue(graphic.layoutXProperty(),35 )
					),
                    new KeyFrame(Duration.millis(duree),
                                                                                new KeyValue(graphic.opacityProperty(),0),
				new KeyValue(graphic.layoutXProperty(),-100 )
					)
                    );
                    timeLine.play();
    }
   
     public static void fadeOutAndGoY(Node graphic, double duree)
    {
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO,
				new KeyValue(graphic.opacityProperty(),1)
				//new KeyValue(graphic.layoutYProperty(),35 )
					),
                    new KeyFrame(Duration.millis(duree),
                                                                                new KeyValue(graphic.opacityProperty(),0),
				new KeyValue(graphic.layoutXProperty(),600 )
					)
                    );
                    timeLine.play();
    }
   
    
    
    
}
