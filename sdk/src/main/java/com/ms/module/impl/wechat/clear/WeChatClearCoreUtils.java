package com.ms.module.impl.wechat.clear;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WeChatClearCoreUtils {

    // 缓冲路径
    public static List<String> cachePaths = new ArrayList<>();
    // 存放网络配置图片路径
    public static List<String> imagePaths = new ArrayList<>();
    // 存放网络配置垃圾路径
    public static List<String> rubbishPaths = new ArrayList<>();
    // 存放网络配置接收文件路径
    public static List<String> receiveFilesPaths = new ArrayList<>();
    // 存放网络配置emoji 路径
    public static List<String> emojiPaths = new ArrayList<>();
    // 存放网络配置朋友圈缓冲路径
    public static List<String> friendsPaths = new ArrayList<>();
    // 存放网络配置聊天语音
    public static List<String> vociePaths = new ArrayList<>();
    // 存放网络配置视频路径
    public static List<String> videoPaths = new ArrayList<>();
    // 存放网络配置用户ID路径
    public static List<String> userIdPaths = new ArrayList<>();

    // 添加缓冲路径
    public void addCachePath(String path) {
        cachePaths.add(path);
    }

    // 添加缓冲路径
    public void addCachePath(List<String> paths) {
        cachePaths.addAll(paths);
    }


    public WeChatClearCoreUtils() {
    }

    public static List<String> removeDuplicateElements(List<String> data) {
        HashSet hashSetClear = new HashSet(data);
        data.clear();
        data.addAll(hashSetClear);
        return data;
    }

    public static List<String> removeFilesWithoutSuffix(List<String> list) {
        List<String> result = new ArrayList();
        Iterator i = list.iterator();

        while (i.hasNext()) {
            String it = (String) i.next();
            File file = new File(it);
            if (file.getName().lastIndexOf(".") != -1) {
                result.add(it);
            }
        }
        return result;
    }

    public static long getFileLastModifiedTime(File file) {
        if (file == null) {
            return 0L;
        } else {
            long time = file.lastModified();
            return time;
        }
    }

    public static long getFileLastModifiedTime(String path) {
        if (path != null && !"".equals(path)) {
            File file = new File(path);
            if (file.exists()) {
                return file.lastModified();
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static void search(List<String> result, String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }

            File[] fileArr = files;
            int var5 = files.length;

            for (int i = 0; i < var5; ++i) {
                File it = fileArr[i];
                if (!it.isHidden()) {
                    if (it.isDirectory()) {
                        search(result, it.getPath());
                    }
                    if (it.exists() && it.isFile() && !it.isDirectory()) {
                        result.add(it.getPath());
                    }
                }
            }
        }
    }

    public static void search(List<String> result, String path, String fileType) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }

            File[] fileArr = files;
            int len = files.length;

            for (int i = 0; i < len; ++i) {
                File it = fileArr[i];
                if (!it.isHidden()) {
                    if (it.isDirectory()) {
                        search(result, it.getPath(), fileType);
                    }

                    if (it.getPath().endsWith(fileType)) {
                        result.add(it.getPath());
                    }
                }
            }
        }

    }

    public static List<String> fileTypeToFiles(String fileType) {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", fileType);
        search(result, "/sdcard/tencent/MicroMsg", fileType);
        search(result, "/sdcard/Android/data/com.tencent.mm", fileType);
        return removeDuplicateElements(result);
    }

    public static List<String> pdf() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".pdf");
        search(result, "/sdcard/tencent/MicroMsg", ".pdf");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".pdf");
        return removeDuplicateElements(result);
    }

    public static List<String> jpg() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".jpg");
        search(result, "/sdcard/tencent/MicroMsg", ".jpg");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".jpg");
        return removeDuplicateElements(result);
    }

    public static List<String> png() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".png");
        search(result, "/sdcard/tencent/MicroMsg", ".png");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".png");
        return removeDuplicateElements(result);
    }

    public static List<String> mp3() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".mp3");
        search(result, "/sdcard/tencent/MicroMsg", ".mp3");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".mp3");
        return removeDuplicateElements(result);
    }

    public static List<String> mp4() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".mp4");
        search(result, "/sdcard/tencent/MicroMsg", ".mp4");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".mp4");
        return removeDuplicateElements(result);
    }

    public static List<String> avi() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".avi");
        search(result, "/sdcard/tencent/MicroMsg", ".avi");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".avi");
        return removeDuplicateElements(result);
    }

    public static List<String> video() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".mp4");
        search(result, "/sdcard/tencent/MicroMsg", ".mp4");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".mp4");
        return removeDuplicateElements(result);
    }

    public static List<String> image() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Pictures/WeiXin", ".png");
        search(result, "/sdcard/tencent/MicroMsg", ".png");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".png");
        search(result, "/sdcard/Pictures/WeiXin", ".jpeg");
        search(result, "/sdcard/tencent/MicroMsg", ".jpeg");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".jpeg");
        search(result, "/sdcard/Pictures/WeiXin", ".jpg");
        search(result, "/sdcard/tencent/MicroMsg", ".jpg");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".jpg");
        search(result, "/sdcard/Pictures/WeiXin", ".webp");
        search(result, "/sdcard/tencent/MicroMsg", ".webp");
        search(result, "/sdcard/Android/data/com.tencent.mm", ".webp");
        return removeDuplicateElements(result);
    }

    public static List<String> receiveFiles() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/Download");
        return removeFilesWithoutSuffix(removeDuplicateElements(result));
    }

    public static List<String> emojiFilter() {
        List<String> result = new ArrayList();
        List<String> accounts = accounts();
        Iterator iterator = accounts.iterator();

        while (iterator.hasNext()) {
            String it = (String) iterator.next();
            String path = "/sdcard/Android/data/com.tencent.mm/MicroMsg/" + it + "/" + "emoji";
            search(result, path);
        }

        List<String> newResult = new ArrayList();

        for (int i = 0; i < result.size(); ++i) {
            if (((String) result.get(i)).contains("_panel_enable") || ((String) result.get(i)).contains("_cover")) {
                newResult.add(result.get(i));
            }
        }

        return removeDuplicateElements(newResult);
    }

    public static List<String> emoji() {
        List<String> result = new ArrayList();
        List<String> accounts = accounts();
        Iterator iterator = accounts.iterator();

        while (iterator.hasNext()) {
            String it = (String) iterator.next();
            String path = "/sdcard/Android/data/com.tencent.mm/MicroMsg/" + it + "/" + "emoji";
            search(result, path);
        }
        return removeDuplicateElements(result);
    }

    public static List<String> accounts() {
        List<String> result = new ArrayList();
        File file = new File("/sdcard/Android/data/com.tencent.mm/MicroMsg");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return result;
            }

            File[] fileArr = files;
            int len = files.length;

            for (int i = 0; i < len; ++i) {
                File it = fileArr[i];
                String fileName = it.getName();
                if (fileName.length() == 32) {
                    result.add(fileName);
                }
            }
        }

        return result;
    }

    public static List<String> voice2() {
        List<String> result = new ArrayList();
        List<String> accounts = accounts();
        Iterator i = accounts.iterator();

        while (i.hasNext()) {
            String it = (String) i.next();
            String path = "/sdcard/Android/data/com.tencent.mm/MicroMsg/" + it + "/" + "voice2";
            search(result, path);
        }

        return removeDuplicateElements(result);
    }

    public static List<String> rubbish() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/crash");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/SQLTrace");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/wxacache");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/WebNetFile");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/CheckResUpdate");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/mapsdk/tencentmapsdk/com.tencent.mm/logs");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/hilive/logs");
        search(result, "/sdcard/Android/data/com.tencent.mm/tencent/MicroMsg/SQLTrace");
        search(result, "/sdcard/Android/data/com.tencent.mm/MicroMsg/xlog");
        return removeDuplicateElements(result);
    }

    public static List<String> cache() {
        List<String> result = new ArrayList();
        search(result, "/sdcard/Android/data/com.tencent.mm/cache");
        return result;
    }

    public static List<String> friendCache() {
        List<String> result = new ArrayList();
        List<String> accounts = accounts();
        Iterator i = accounts.iterator();

        while (i.hasNext()) {
            String it = (String) i.next();
            String path = "/sdcard/Android/data/com.tencent.mm/cache/" + it + "/" + "sns";
            search(result, path);
        }

        return result;
    }

    public static long getFileLength(List<String> datas) {
        if (datas == null) {
            return 0L;
        } else {
            long count = 0L;

            String it;
            for (Iterator i = datas.iterator(); i.hasNext(); count += (new File(it)).length()) {
                it = (String) i.next();
            }

            return count;
        }
    }

    public static long getFileLength(List<String>... lists) {
        long count = 0L;

        for (int i = 0; i < lists.length; ++i) {
            List<String> list = lists[i];

            String it;
            for (Iterator j = list.iterator(); j.hasNext(); count += (new File(it)).length()) {
                it = (String) j.next();
            }
        }

        return count;
    }

    public static long getFileLength(String path) {
        return (new File(path)).length();
    }

    public static boolean delete(String path) {
        if (path != null && !"".equals(path)) {
            File file = new File(path);
            return delete(file);
        } else {
            return false;
        }
    }

    public static boolean delete(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}
