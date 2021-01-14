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
    int z = 0;
    for (int i = 0; i<=z;i++){
      for (int j = 0; j<data.size();j++){
        if (i == 0 && length(data.get(j))>z){
          z=length(data.get(j));
        }
        int x = nth(data.get(j),i);
        all[x].add(data.get(j));
      }
      while (data.size()!=0){
        data.remove(0);
      }
      merge(data,all);
    }
  }

  private static void radixSortSimpleRev(SortableLinkedList data){
    SortableLinkedList[] all = new SortableLinkedList[10];
    for(int i = 0; i < all.length; i++) {
      all[i] = new SortableLinkedList();
    }
    int z = 0;
    for (int i = 0; i<=z;i++){
      for (int j = 0; j<data.size();j++){
        if (i == 0 && length(data.get(j))>z){
          z=length(data.get(j));
        }
        int x = nth(data.get(j),i);
        all[9-x].add(data.get(j));
      }
      while (data.size()!=0){
        data.remove(0);
      }
      merge(data,all);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList negative = new SortableLinkedList();
    SortableLinkedList positive = new SortableLinkedList();
    for (int i = 0; i<data.size();i++){
      if (data.get(i)<0){
        negative.add(data.get(i));
      }
      else{
        positive.add(data.get(i));
      }
    }
    radixSortSimpleRev(negative);
    radixSortSimple(positive);
    while (data.size()!=0){
      data.remove(0);
    }
    data.extend(negative);
    data.extend(positive);
  }
}
