package example.android.playtubesampleactivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.content.Context;

// YouTube����1���̏��i�[�p�N���X
public class YouTubeVideoItem  implements Serializable {

	private static final long serialVersionUID = 1L;

	// ����^�C�g��
    private String title;

    // ����URL
    private String mpeg4spURL;

    // �T���l�C���摜URL
    private String thumbnailURL;

    // �R���X�g���N�^
    public YouTubeVideoItem(String text, String mpeg4spURL, String thumbnailURL) {
        this.title = text;
        this.mpeg4spURL = mpeg4spURL;
        this.thumbnailURL = thumbnailURL;
    }

    // ����^�C�g�����擾���郁�\�b�h
    public String getTitle() {
        return title;
    }

    // ����URL���擾���郁�\�b�h
    public String getMpeg4spURL() {
        return mpeg4spURL;
    }

    // �T���l�C���摜URL���擾���郁�\�b�h
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    // ����^�C�g�����Z�b�g���郁�\�b�h
    public String setTitle() {
        return title;
    }

    // ����URL���Z�b�g���郁�\�b�h
    public String setMpeg4spURL() {
        return mpeg4spURL;
    }

    // �T���l�C���摜URL���Z�b�g���郁�\�b�h
    public String setThumbnailURL() {
        return thumbnailURL;
    }

    // ������\����Ԃ����\�b�h
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
     * �ۑ�����t�@�C����
     */
    private final static String FILE_NAME = "ViewDto.obj";

    /**
     * �f�[�^��ۑ�����
     * @param context
     * @param object �ۑ�����I�u�W�F�N�g
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
     * �f�[�^��ǂݍ���
     * @param context
     * @return �ۑ����Ă���f�[�^���Ȃ��ꍇ�� null
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