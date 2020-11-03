package com.ms.module.impl.wechat;

import com.ms.module.impl.wechat.clear.R;
import com.ms.module.impl.wechat.clear.WeChatClearCoreUtils;
import com.ms.module.supers.client.Modules;
import com.ms.module.supers.inter.wechat.IWeChatClearAdapter;

import java.util.List;

public class WeChatClearImpl extends IWeChatClearAdapter {


    public WeChatClearImpl() {
        super();
    }

    @Override
    public List<String> log() {
        return null;
    }

    @Override
    public List<String> accountIds() {
        return WeChatClearCoreUtils.accounts();
    }

    @Override
    public List<String> image() {
        return WeChatClearCoreUtils.image();
    }

    @Override
    public List<String> video() {
        return WeChatClearCoreUtils.video();
    }

    @Override
    public List<String> voice() {
        return WeChatClearCoreUtils.voice2();
    }

    @Override
    public List<String> emoji() {
        return WeChatClearCoreUtils.emoji();
    }

    @Override
    public List<String> cache() {
        return WeChatClearCoreUtils.cache();
    }

    @Override
    public List<String> temp() {
        return null;
    }

    @Override
    public List<String> rubbish() {
        return WeChatClearCoreUtils.rubbish();
    }

    @Override
    public void warning(String text) {

    }

    @Override
    public String name() {
        return Modules.getUtilsModule().getResUtils().getString(Modules.getUtilsModule().getResUtils().getId("com_ms_module_wechat_clear_name"));
    }

    @Override
    public String releaseDate() {
        return Modules.getUtilsModule().getResUtils().getString(Modules.getUtilsModule().getResUtils().getId("com_ms_module_wechat_clear_release_date"));
    }

    @Override
    public String version() {
        return Modules.getUtilsModule().getResUtils().getString(Modules.getUtilsModule().getResUtils().getId("com_ms_module_wechat_clear_version"));
    }

    @Override
    public String dependencies() {
        return Modules.getUtilsModule().getResUtils().getString(Modules.getUtilsModule().getResUtils().getId("com_ms_module_wechat_clear_dependencies"));
    }
}
