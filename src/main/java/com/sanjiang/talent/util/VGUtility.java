package com.sanjiang.talent.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class VGUtility {
    private static final Logger logger = LoggerFactory.getLogger(VGUtility.class);
    private static final String PROPERTY_FILE_PATH = "VG_PROPERTY.properties";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public VGUtility() {
    }

    public static boolean isEmpty(Object obj) {
        if (!(obj instanceof String)) {
            return obj == null;
        } else {
            return obj == null || obj.equals("");
        }
    }

    public static int toInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (Exception var2) {
            return 0;
        }
    }

    public static double toDouble(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (Exception var2) {
            return 0.0D;
        }
    }

    public static double convertToDouble(Object input) {
        if (isEmpty(input)) {
            return 0.0D;
        } else if (input instanceof String) {
            return toDouble((String)input);
        } else if (input instanceof Double) {
            return (Double)input;
        } else if (input instanceof Long) {
            return (double)(Long)input;
        } else if (input instanceof Integer) {
            return (double)(Integer)input;
        } else if (input instanceof Float) {
            return (double)(Float)input;
        } else {
            throw new RuntimeException("ConvertToDouble Unsupport Object Type[" + input.getClass().getName() + "]");
        }
    }

    public static String toDoubleStr(Double input, String format) {
        return toDoubleStr(input, format, RoundingMode.HALF_UP);
    }

    public static String toDoubleStr(Double input, String format, RoundingMode mode) {
        try {
            if (isEmpty(input)) {
                return "";
            } else {
                if (isEmpty(format)) {
                    format = "0.0000";
                }

                DecimalFormat formatter = new DecimalFormat(format);
                formatter.setRoundingMode(mode);
                BigDecimal a = new BigDecimal(formatter.format(input));
                return a.toString();
            }
        } catch (Exception var5) {
            logger.debug("Format Double String Exception", var5);
            return "";
        }
    }

    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(toDoubleStr(123416.23213D, (String)null));
    }

    public static String encodeByMD5(String originString) {
        return encodeByMD5(originString.getBytes());
    }

    public static String encodeByMD5(byte[] originByte) {
        if (originByte != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originByte);
                return byteArrayToHexString(results);
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }



    public static String ToUTF8String(String orgStr) {
        if (orgStr == null) {
            return null;
        } else {
            try {
                return new String(orgStr.getBytes("ISO8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static Date toDateObj(String input, String format) {
        try {
            if (isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(input);
        } catch (Exception var3) {
            logger.error("Exception when format data string", var3);
            return null;
        }
    }

    public static String toDateStr(Date input, String format) {
        return toDateStr(input, format, Locale.getDefault());
    }

    public static String toDateStr(Date input, String format, Locale locale) {
        try {
            if (isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
            return formatter.format(input);
        } catch (Exception var4) {
            logger.debug("Exception when format data object", var4);
            return null;
        }
    }

    public static void SaveProperty(String key, String value) {
        Properties pro = new Properties();
        String var3 = "VG_PROPERTY.properties";
        synchronized("VG_PROPERTY.properties") {
            try {
                File propertyFile = new File("VG_PROPERTY.properties");
                if (propertyFile.exists()) {
                    pro.load(new FileInputStream("VG_PROPERTY.properties"));
                }

                pro.put(key, value);
                pro.store(new FileOutputStream(propertyFile), "Save Property [" + key + "][" + value + "]");
            } catch (Exception var6) {
                logger.error("Exception when save property.", var6);
            }

        }
    }

    public static String ReadProperty(String key, String defaultValue) {
        Properties pro = new Properties();
        String var3 = "VG_PROPERTY.properties";
        synchronized("VG_PROPERTY.properties") {
            String var10000;
            try {
                File propertyFile = new File("VG_PROPERTY.properties");
                if (propertyFile.exists()) {
                    pro.load(new FileInputStream("VG_PROPERTY.properties"));
                }

                if (null == pro.getProperty(key)) {
                    var10000 = defaultValue;
                    return var10000;
                }

                var10000 = pro.getProperty(key);
            } catch (Exception var6) {
                logger.error("Exception when read property.", var6);
                return defaultValue;
            }

            return var10000;
        }
    }

    public static void SaveProperty(String fileName, String key, String value) {
        Properties pro = new Properties();
        String var4 = "VG_PROPERTY.properties";
        synchronized("VG_PROPERTY.properties") {
            try {
                File propertyFile = new File(fileName + ".properties");
                if (propertyFile.exists()) {
                    pro.load(new FileInputStream(fileName + ".properties"));
                }

                pro.put(key, value);
                pro.store(new FileOutputStream(propertyFile), "Save Property [" + key + "][" + value + "]");
            } catch (Exception var7) {
                logger.error("Exception when save property.", var7);
            }

        }
    }

    public static String ReadProperty(String fileName, String key, String defaultValue) {
        Properties pro = new Properties();
        String var4 = "VG_PROPERTY.properties";
        synchronized("VG_PROPERTY.properties") {
            String var10000;
            try {
                File propertyFile = new File(fileName + ".properties");
                if (propertyFile.exists()) {
                    pro.load(new FileInputStream(fileName + ".properties"));
                }

                if (null == pro.getProperty(key)) {
                    var10000 = defaultValue;
                    return var10000;
                }

                var10000 = pro.getProperty(key);
            } catch (Exception var7) {
                logger.error("Exception when read property.", var7);
                return defaultValue;
            }

            return var10000;
        }
    }

    public static void CopyFile(InputStream in, OutputStream out) {
        try {
            byte[] buf = new byte[20480];
            boolean var3 = false;

            int count;
            while((count = in.read(buf)) > 0) {
                out.write(buf, 0, count);
            }

        } catch (IOException var4) {
            logger.error("Exception when copy file", var4);
            throw new RuntimeException("拷贝文件出错!");
        }
    }

    public static byte[] GetContent(InputStream in) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            CopyFile(in, out);
            byte[] result = out.toByteArray();
            out.close();
            return result;
        } catch (IOException var3) {
            logger.error("Exception when get content", var3);
            throw new RuntimeException("获取内容出错!");
        }
    }

    public static byte[] SerializeObject(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Serializable) {
            try {
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bao);
                oos.writeObject(obj);
                oos.close();
                byte[] result = bao.toByteArray();
                bao.close();
                return result;
            } catch (Exception var4) {
                logger.error("Exception when serialize object", var4);
                throw new RuntimeException("序列化出错!");
            }
        } else {
            throw new RuntimeException("对象无法序列化!");
        }
    }

    public static Object UnserializeObject(byte[] input) {
        if (input == null) {
            return null;
        } else {
            try {
                ByteArrayInputStream bai = new ByteArrayInputStream(input);
                ObjectInputStream ois = new ObjectInputStream(bai);
                Object obj = ois.readObject();
                return obj;
            } catch (Exception var4) {
                logger.error("Exception when unserialize object", var4);
                throw new RuntimeException();
            }
        }
    }

    public static Double mathAdd(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.add(b2).doubleValue());
    }

    public static Double mathSubtract(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.subtract(b2).doubleValue());
    }

    public static Double mathMultiply(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.multiply(b2).doubleValue());
    }

    public static Double mathDivide(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.divide(b2, 10, 4).doubleValue());
    }

    public static String toUpperCase(String in) {
        return isEmpty(in) ? "" : in.toUpperCase();
    }

    public static String toLowerCase(String in) {
        return isEmpty(in) ? "" : in.toLowerCase();
    }

}
