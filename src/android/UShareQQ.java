package news.chen.yu.ionic;

import org.apache.cordova.*;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class UShareQQ extends CordovaPlugin {

    private Boolean __init = false;

    private void init() {
        if(!this.__init) {
            this.__init = true;
            UShare.mediaList.add(SHARE_MEDIA.QQ);
            UShare.mediaList.add(SHARE_MEDIA.QZONE);
            String appKey = preferences.getString("ushare_qq_android_app_id", "");
            String appSecret = preferences.getString("ushare_qq_android_app_key", "");
            LOG.d("u-share", "QQ key: " + appKey);
            LOG.d("u-share", "QQ secret: " + appSecret);
            PlatformConfig.setQQZone(appKey, appSecret);
        }
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.init();
    }
}