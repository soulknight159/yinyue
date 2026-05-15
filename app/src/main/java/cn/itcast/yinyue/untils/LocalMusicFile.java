package cn.itcast.yinyue.untils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.yinyue.bean.Music;

public class LocalMusicFile {
    private static final String TAG = "LocalMusicFile";
    public static List<Music> getLoadMusic(Context context) {
        List<Music> musicList = new ArrayList<>();
        Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.SIZE
                // 注意：不建议再使用 MediaStore.Audio.Media.DATA
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        try (Cursor cursor = context.getContentResolver().query(contentUri, projection, selection, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
                int titleIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
                int artistIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
                int durationIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION);
                int albumIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM);
                int sizeIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE);

                do {
                    int id = cursor.getInt(idIndex);
                    String title = cursor.getString(titleIndex);
                    String artist = cursor.getString(artistIndex);
                    long duration = cursor.getLong(durationIndex);
                    String album = cursor.getString(albumIndex);
                    long size = cursor.getLong(sizeIndex);

                    //构造每个音乐文件的 Content URI
                    Uri fileUri = ContentUris.withAppendedId(contentUri, id);

                    Music music = new Music();
                    music.setId(id);
                    music.setTitle(title);
                    music.setArtist(artist);
                    music.setDuration(duration);
                    music.setAlbum(album);
                    music.setSize(size);
                    music.setPath(fileUri.toString());      // 设置 URI 供播放使用
                    music.setSourceType(0);

                    musicList.add(music);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "getLoadMusic: ", e.fillInStackTrace());
        }
        return musicList;
    }
}
