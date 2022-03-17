package cn.springboot.util.salt;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * @author 胡桃夹子
 * @Description 封装各种格式的编码解码工具类<br>
 * 1.Commons-Codec的 hex/base64 编码 <br>
 * 2.自制的base62 编码 <br>
 * 3.Commons-Lang的xml/html escape <br>
 * 4.JDK提供的URLEncoder
 * @date Apr 12, 2017 9:37:43 AM
 */
public class Encodes {

    private static final String DEFAULT_URL_ENCODING = "UTF-8";
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input) {
        return Hex.encodeHexString(input);
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw Exceptions.unchecked(e);
        }
    }
}
