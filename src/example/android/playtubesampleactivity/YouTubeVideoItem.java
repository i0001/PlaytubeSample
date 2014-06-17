package example.android.playtubesampleactivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.content.Context;

// YouTube動画1件の情報格納用クラス
public class YouTubeVideoItem  implements Serializable {

	private static final long serialVersionUID = 1L;

	// 動画タイトル
    private String title;

    // 動画URL
    private String mpeg4spURL;

    // サムネイル画像URL
    private String thumbnailURL;

    // コンストラクタ
    public YouTubeVideoItem(String text, String mpeg4spURL, String thumbnailURL) {
        this.title = text;
        this.mpeg4spURL = mpeg4spURL;
        this.thumbnailURL = thumbnailURL;
    }

    // 動画タイトルを取得するメソッド
    public String getTitle() {
        return title;
    }

    // 動画URLを取得するメソッド
    public String getMpeg4spURL() {
        return mpeg4spURL;
    }

    // サムネイル画像URLを取得するメソッド
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    // 動画タイトルをセットするメソッド
    public String setTitle() {
        return title;
    }

    // 動画URLをセットするメソッド
    public String setMpeg4spURL() {
        return mpeg4spURL;
    }

    // サムネイル画像URLをセットするメソッド
    public String setThumbnailURL() {
        return thumbnailURL;
    }

    // 文字列表現を返すメソッド
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("YouTubeVideoItem={");
        sb.append("title=" + title + ", ");
        sb.append("mpeg4spURL=" + mpeg4spURL + ", ");
        sb.append("thumbnailURL=" + thumbnailURL);
        sb.append("}");
        return sb.toString();
    }

    /**
     * 保存するファイル名
     */
    private final static String FILE_NAME = "ViewDto.obj";

    /**
     * データを保存する
     * @param context
     * @param object 保存するオブジェクト
     */
    public static void store(Context context, Serializable object){
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            out.writeObject(object);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * データを読み込む
     * @param context
     * @return 保存しているデータがない場合は null
     */
    public static Object load(Context context){
        Object retObj = null;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    context.openFileInput(FILE_NAME)
            );
            retObj = in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return retObj;
    }
}