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

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0 ;i<buckets.length;i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] all = new SortableLinkedList[10];
    for(int i = 0; i < all.length; i++) {
      all[i] = new SortableLinkedList();
    }
    int z = 1;
    for (int i = 0; i<z;i++){
      while(data.size()!=0){
        int a = data.remove(0);
        if (i == 0 && length(a)>z){
          z=length(a);
        }
        all[nth(a,i)].add(a);
      }
      merge(data,all);
    }
  }

  private static void radixSortSimpleRev(SortableLinkedList data){
    SortableLinkedList[] all = new SortableLinkedList[10];
    for(int i = 0; i < all.length; i++) {
      all[i] = new SortableLinkedList();
    }
    int z = 1;
    for (int i = 0; i<z;i++){
      while(data.size()!=0){
        int a = data.remove(0);
        if (i == 0 && length(a)>z){
          z=length(a);
        }
        all[9-nth(a,i)].add(a);
      }
      merge(data,all);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList negative = new SortableLinkedList();
    SortableLinkedList positive = new SortableLinkedList();
    while (data.size()!=0){
      int a = data.remove(0);
      if (a < 0){
        negative.add(a);
      }
      else{
        positive.add(a);
      }
    }
    radixSortSimpleRev(negative);
    radixSortSimple(positive);
    data.extend(negative);
    data.extend(positive);
  }
}
