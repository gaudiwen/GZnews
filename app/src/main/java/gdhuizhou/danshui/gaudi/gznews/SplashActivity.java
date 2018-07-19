package gdhuizhou.danshui.gaudi.gznews;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends Activity {

    private RelativeLayout rl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl_splash_root =(RelativeLayout) findViewById(R.id.rl_splash_root);

        //渐变 缩放 旋转
        AlphaAnimation aa =new AlphaAnimation(0,1);
        aa.setDuration(500);//动画持续时间
        aa.setFillAfter(true);

        ScaleAnimation sa =new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(500);//动画持续时间
        sa.setFillAfter(true);

        RotateAnimation ra=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(1000);
        ra.setFillAfter(true);

        AnimationSet set =new AnimationSet(false);
        //添加三个动画没有先后顺序，便于同时播放动画
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);

        rl_splash_root.startAnimation(set);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Toast.makeText(SplashActivity.this,"动画完成",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
