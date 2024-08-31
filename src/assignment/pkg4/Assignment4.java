package assignment.pkg4;
import java.util.Scanner;
public class Assignment4 
{
//c1:method nhập mảng từ bàn phím//
    public static void importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap cac phan tu cua mang: ");
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = scanner.nextFloat();
        }
    }
//c2:method xuất mảng ra màn hình//
    public static void printData(float[] arrays) {
        for (float value : arrays) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
//c3:method tìm và in ra giá trị lớn thứ 2 trong mảng//
    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            System.out.println("Mang can co it nhat hai phan tu!");
            return Float.NaN; // Trả về giá trị không hợp lệ
        }
//khởi tạo max1 và max2 với giá trị nhỏ nhất//
        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;
        for (float value : arrays) {
            if (value > max1) {
//cập nhật max2 trước khi cập nhật max1//
                max2 = max1;
                max1 = value;
            } else if (value > max2 && value != max1) {
//cập nhật max2 nếu giá trị lớn hơn max2 và khác max1//
                max2 = value;
            }
        }
        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Khong tim thay gia tri lon thu hai!");
        }
        return max2;
    }
//c4:method xoá các phần tử lẻ ra khỏi mảng//
    public static float[] deleteOddNumber(float[] arrays) {
        int count = 0;
        for (float value : arrays) {
            if (value % 2 == 0) {
                count++;
            }
        }
        float[] result = new float[count];
        int index = 0;
        for (float value : arrays) {
            if (value % 2 == 0) {
                result[index++] = value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//c1//
        System.out.println("Nhap so luong phan tu mang: ");
        int size = scanner.nextInt();
        float[] array = new float[size];
        importData(array);
//c2//
        System.out.println("Mang vua nhap la: ");
        printData(array);

//c3//
        float max2 = findMax2(array); // Gọi phương thức
        if (!Float.isNaN(max2)) {  // Kiểm tra xem nếu là NaN thì true, ngược lại là false
            System.out.println("Gia tri lon thu hai trong mang la: " + max2);
        }
//c4//
        float[] ketqua = deleteOddNumber(array);
        System.out.println("mang sau khi xoa phan tu le la :");
        printData(ketqua);
        }
}
