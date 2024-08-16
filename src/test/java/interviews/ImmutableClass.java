package interviews;

final class ImmutableClass {
    private int i;
    public ImmutableClass(int i){
        this.i=i;
    }

    public int getI(){
        return i;
    }

    public ImmutableClass modify(int i){
        if(this.i==i)
            return this;
        else return new ImmutableClass(i);
    }

    public static void main(String[] args) {
        ImmutableClass im = new ImmutableClass(10);
        System.out.println(im.getI());
        ImmutableClass im1 = im.modify(10);
        System.out.println(im==im1);
        ImmutableClass im2 = im.modify(100);
        System.out.println(im==im2);
    }
}
