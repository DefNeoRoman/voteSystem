package sandbox;


import java.util.HashMap;
import java.util.Map;

public class SandBox {
    private static final Map<String,AppleDevice> deviceHashMap = new HashMap<>();

    {
        //keyWord достаем через Reflection API
    deviceHashMap.put("WhiteIphone",new WhiteIphone());
    deviceHashMap.put("BlackIphone",new BlackIphone());
    deviceHashMap.put("GoldIphone" ,new GoldIphone());
    deviceHashMap.put("WhiteIpad"  ,new WhiteIpad());
    deviceHashMap.put("BlackIpad"  ,new BlackIpad());
    deviceHashMap.put("GoldIpad"   ,new GoldIpad());
    deviceHashMap.put("WhiteIpod"  ,new WhiteIpod());
    deviceHashMap.put("BlackIpod"  ,new BlackIpod());
    deviceHashMap.put("GoldIpod"   ,new GoldIpod());
    }
    public static void main(String[] args) {
        SandBox sandBox = new SandBox();
       AppleDevice appleDevice = sandBox.createDevice("Iphone","Black");

        System.out.println(appleDevice.getClass().getName());

    }
    public AppleDevice createDevice(String type,String color){
        if(!(type.isEmpty() && color.isEmpty())){
            AppleDevice appleDevice;
            // тут всего 2 строки я не буду из-за этого пользоваться StringBuilder
            String keyWord = color+type;
            appleDevice = deviceHashMap.get(keyWord);
            return appleDevice;
        }
        return new AppleDevice();
    }

    public class AppleDevice {
        @Override
        public String toString() {
            return "EmptyAppleDevice{}";
        }
    }
    public class WhiteIphone extends  AppleDevice{

    }
    public class BlackIphone extends  AppleDevice{

    }
    public class GoldIphone extends  AppleDevice{

    }
    public class WhiteIpad extends  AppleDevice{

    }
    public class BlackIpad extends  AppleDevice{

    }
    public class GoldIpad extends  AppleDevice{

    }
    public class WhiteIpod extends  AppleDevice{

    }
    public class BlackIpod extends  AppleDevice{

    }
    public class GoldIpod extends  AppleDevice{

    }


}
