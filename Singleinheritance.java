class Basicphone{
    String message = "hii,hello";
    void MakeCall() {
        int phonenumber = 123456789;
        System.out.println("call phonenumber = " + phonenumber);
    
    }
void sendMessage(){
    String message = "hii,hello";
System.out.println("Sending a message = " + message);
}
    }
    
    class Smartphone extends Basicphone{
        void takePhoto() {
            String photo = "jpgl.file";

            System.out.println("Taking a photo = " + photo);

        }
    }
    
    public class Singleinheritance{
        public static void main(String[] args){
            Smartphone myPhone = new Smartphone();
      
            //Call methods from parent class
            myPhone.MakeCall();
            myPhone.sendMessage();
            myPhone.takePhoto();

            //Call method from parent class
            
        }
    }
