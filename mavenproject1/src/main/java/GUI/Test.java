/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author huylauri
 */
public class Test {

    public static void main(String[] args) {
        String inputString = "WHERE MaPhongBan = 'PB_HanhChinh'    MaPhongBan   AND  MaPhongBan = 'PB_CSKH'  AND  DiaChi LIKE N'%Hà N?i%' MaPhongBan MaPhongBan";
        String searchStr = "MaPhongBan";
        int count = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = inputString.indexOf(searchStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += searchStr.length();
            }
        }
        System.out.println("So lan xuat hien la: "+count);
    }
}
