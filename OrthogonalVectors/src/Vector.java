public class Vector{
    int[] array; 
    int length; 

    public Vector(int length){ 
        this.length = length; 
        this.array = new int[length];
    }
/*
    public int[] populate(String[] stringInts){ 

        for(int i = 0; i<stringInts.length; i++){
            try{
            int realInt = Integer.parseInt(stringInts[i]); 
            array[i] = realInt;
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
           
        }
        return array;
    }*/ 
    public void insertValue(int index, int value){
        array[index]= value;

    }
    public int getValue(int index){
        return array[index];
    }
}