package com.example.lj.draganddrop;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class DragAndDrop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);

        ImageView wolf, house;

        wolf=(ImageView)findViewById(R.id.wolf);
        house=(ImageView)findViewById(R.id.house);

        final class ChoiceTouchListener implements View.OnTouchListener {
            public boolean onTouch(View view, MotionEvent motionEvent){
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    //setup drag
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                    view.startDrag(data, shadowBuilder, view, 0);
                    return true;
                }
                else
                    return false;
            }
        }

        class ChoiceDragListener implements View.OnDragListener {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                //handle drag events
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        //no action necessary
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        //no action necessary
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        //no action necessary
                        break;
                    case DragEvent.ACTION_DROP:
                        //handle the dragged view being dropped over a drop view
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.INVISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        //no action necessary
                        break;
                    default:
                        break;
                }
                return true;
            }
        }

        wolf.setOnTouchListener(new ChoiceTouchListener());
        house.setOnDragListener(new ChoiceDragListener());
    }
}
