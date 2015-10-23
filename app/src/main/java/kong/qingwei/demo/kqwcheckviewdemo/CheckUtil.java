package kong.qingwei.demo.kqwcheckviewdemo;

/**
 * Created by kongqw on 2015/10/23.
 */
public class CheckUtil {



    /**
     * ����������ߵ���ʼ������ͽ���������
     *
     * @param height ����CheckView�ĸ߶�ֵ
     * @param width  ����CheckView�Ŀ��ֵ
     * @return ��ʼ������ͽ���������
     */
    public static int[] getLine(int height, int width) {
        int[] tempCheckNum = {0, 0, 0, 0};
        for (int i = 0; i < 4; i += 2) {
            tempCheckNum[i] = (int) (Math.random() * width);
            tempCheckNum[i + 1] = (int) (Math.random() * height);
        }
        return tempCheckNum;
    }


    /**
     * ����������Բ�ĵ�����
     *
     * @param height ����CheckView�ĸ߶�ֵ
     * @param width  ����CheckView�Ŀ��ֵ
     * @return
     */
    public static int[] getPoint(int height, int width) {
        int[] tempCheckNum = {0, 0, 0, 0};
        tempCheckNum[0] = (int) (Math.random() * width);
        tempCheckNum[1] = (int) (Math.random() * height);
        return tempCheckNum;
    }


    /**
     * ��֤�Ƿ���ȷ
     *
     * @param userCheck �û��������֤��
     * @param checkNum  ��֤�ؼ������������
     * @return
     */
    public static boolean checkNum(String userCheck, int[] checkNum) {
        if (userCheck.length() != 4) {
            return false;
        }
        String checkString = "";
        for (int i = 0; i < 4; i++) {
            checkString += checkNum[i];
        }
        if (userCheck.equals(checkString)) {
            return true;
        } else {
            return false;
        }
    }




}


