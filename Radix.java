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
    SortableLinkedList a = new SortableLinkedList();
    SortableLinkedList b = new SortableLinkedList();
    SortableLinkedList c = new SortableLinkedList();
    SortableLinkedList d = new SortableLinkedList();
    SortableLinkedList e = new SortableLinkedList();
    SortableLinkedList f = new SortableLinkedList();
    SortableLinkedList g = new SortableLinkedList();
    SortableLinkedList h = new SortableLinkedList();
    SortableLinkedList k = new SortableLinkedList();
    SortableLinkedList l = new SortableLinkedList();
    SortableLinkedList[] all = {a,b,c,d,e,f,g,h,k,l};
    int z = 0;
    for (int i = 0; i<=z;i++){
      for (int j = 0; j<data.size();j++){
        if (i == 0 && length(data.get(j))>z){
          z=length(data.get(j));
        }
        int x = nth(data.get(j),i);
        all[x].add(data.get(j));
      }
      data = new SortableLinkedList();
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
    radixSortSimple(negative);
    radixSortSimple(positive);
    data = new SortableLinkedList();
    for (int i = negative.size()-1 ;i>=0;i--){
      data.add(negative.get(i));
    }
    data.extend(positive);
  }
}
