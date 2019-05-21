package big33project;

public class FoodDTO {
String tn;
String name;
String price;
String coo;
String count;

public String getTn() {
return tn;
}
public void setTn(String tn) {
this.tn = tn;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getPrice() {
return price;
}
public void setPrice(String price) {
this.price = price;
}
public String getCoo() {
return coo;
}
public void setCoo(String coo) {
this.coo = coo;
}
public String getCount() {
return count;
}
public void setCount(String count) {
this.count = count;
 


}
@Override
public String toString() {
	return "FoodDTO [tn=" + tn + ", name=" + name + ", price=" + price + ", coo=" + coo + ", count=" + count + "]";
}

 
}
