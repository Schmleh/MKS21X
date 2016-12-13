public class Sorts{

    public static String name(){
	return "01.Yue.Min";
    }
    
    public static void selectionSort(int[] data){
	for (int location = 0; location < data.length; location ++){
	    int lookat = location;
	    int current = location;
	    int tempspot =  data[location];
	    lookat ++;
	    while (lookat < data.length){
		if (data[lookat] < tempspot){
		    tempspot = data[lookat];
		    current = lookat;
		}
		lookat ++;
	    }
	    data[current] = data[location];
	    data[location] = tempspot;
	}
    }

    public static void main(String[] args){
	int[] hos = {1,0,8,4,9,6,7,2,6,3,4,7,2};
	selectionSort(hos);
	for (int i : hos) {
	    System.out.println(i);
	}
    }
}
