import java.lang.Math;
public class Radix{

  public static int nth(int n, int col){
    return Math.abs(n/(int)Math.pow(10,col)%10);
  }

  public static int length(int n){
    if (n == 0){
      return 1;
    }
    n = Math.abs(n);
    return (int)Math.log10(n)+1;
  }
}
