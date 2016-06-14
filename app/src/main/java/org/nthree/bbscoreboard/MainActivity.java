    package org.nthree.bbscoreboard;

            import android.graphics.Color;
            import android.graphics.Typeface;
            import android.media.MediaPlayer;
            import android.os.Bundle;
            import android.support.v7.app.ActionBarActivity;
            import android.support.v7.app.AppCompatActivity;
            import android.view.View;
            import android.widget.CompoundButton;
            import android.widget.RelativeLayout;
            import android.widget.TextView;
            import android.widget.ToggleButton;

            import org.nthree.moneytracker.R;
            import org.w3c.dom.Text;

            import java.text.NumberFormat;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

        int homeCounter = 0;
        int visitorCounter = 0;

        ToggleButton t;
        MediaPlayer airHorn;
        RelativeLayout r;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            /***
             * Toggle Buttons
             *********************************************************/
            t = (ToggleButton) findViewById(R.id.airHornToggle);
            t.setOnCheckedChangeListener(this);

            r=(RelativeLayout)findViewById(R.id.backgroundColor);
            final ToggleButton b = (ToggleButton)findViewById(R.id.backgroundToggle);

            /**
             *  BACKGROUND COLOR TOGGLE BUTTON
             ********************************/
            b.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v){
                    if(b.isChecked())

                    r.setBackgroundColor(Color.WHITE);
                    else
                        r.setBackgroundColor(Color.BLACK);
            }});



            /***
             * TEXT FONT!!!
             *********************************************************/

            String listviewandroid= "fonts/digital-7.ttf";
            Typeface myTypeface = Typeface.createFromAsset(getAssets(), listviewandroid);
            TextView myTextView = (TextView)findViewById(R.id.visitor_counter);
            TextView myTextView2= (TextView)findViewById(R.id.home_counter);
            TextView myTextView3= (TextView)findViewById(R.id.Scoreboard);
            TextView myTextView4= (TextView)findViewById(R.id.visitor);
            TextView myTextView5= (TextView)findViewById(R.id.home);
            TextView myTextView6= (TextView)findViewById(R.id.home_three_points);
            TextView myTextView7= (TextView)findViewById(R.id.home_two_points);
            TextView myTextView8= (TextView)findViewById(R.id.home_freethrow);
            TextView myTextView9= (TextView)findViewById(R.id.visitor_three_points);
            TextView myTextView10= (TextView)findViewById(R.id.visitor_two_points);
            TextView myTextView11= (TextView)findViewById(R.id.visitor_freethrow);


            myTextView.setTypeface(myTypeface);
            myTextView2.setTypeface(myTypeface);
            myTextView3.setTypeface(myTypeface);
            myTextView4.setTypeface(myTypeface);
            myTextView5.setTypeface(myTypeface);
            myTextView6.setTypeface(myTypeface);
            myTextView7.setTypeface(myTypeface);
            myTextView8.setTypeface(myTypeface);
            myTextView9.setTypeface(myTypeface);
            myTextView10.setTypeface(myTypeface);
            myTextView11.setTypeface(myTypeface);

        }

            /*****
             * AIRHORN SOUND EFFECT TOGGLE BUTTON
             *****************************/

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    airHorn = MediaPlayer.create(this, R.raw.airhorn);
                    airHorn.setLooping(true);
                    airHorn.start();

                } else {
                    airHorn.release();
                    airHorn = null;

                }
            }


        /**
         * Adding points to home counter
         **************************************/

        public void home_three_points(View view){
            homeCounter = homeCounter+3;
            displayHome(homeCounter);
        }

        public void home_two_points(View view){
            homeCounter = homeCounter+2;
            displayHome(homeCounter);
        }

        public void home_freethrow(View view){
            homeCounter = homeCounter+1;
            displayHome(homeCounter);
        }


        public void reset(View view){
            homeCounter = 0;
            visitorCounter = 0;

            displayHome(homeCounter);
            displayVisitor(visitorCounter);
        }

        /*
         * Adding points to visitor counter
         ************************************/


        public void visitor_three_points(View view){
            visitorCounter = visitorCounter+3;
            displayVisitor(visitorCounter);
        }

        public void visitor_two_points(View view){
            visitorCounter = visitorCounter+2;
            displayVisitor(visitorCounter);
        }
        public void visitor_freethrow(View view){
            visitorCounter = visitorCounter+1;
            displayVisitor(visitorCounter);
        }

        /**
         * This method displays the given quantity value on the screen.
         */
        private void displayHome(int number) {
            TextView homeCounter = (TextView) findViewById(
                    R.id.home_counter);
            homeCounter.setText("" + number);
        }

        private void displayVisitor(int number) {
            TextView visitorCounter = (TextView) findViewById(
                    R.id.visitor_counter);
            visitorCounter.setText("" + number);
        }


    }