package com.aking.excel.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtil {
    public StringUtil() {
    }

    public static String substringByChinsesWord(String str, int startIndex, int endIndex) throws RuntimeException {
        if (isEmpty(str)) {
            return str;
        } else if (startIndex >= endIndex) {
            throw new RuntimeException("[StringUtil.substringByChinsesWord]:failure, and startIndex>=endIndex");
        } else {
            int shortCharNum = 0;
            int longCharNum = 0;
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                if (3000 <= ch) {
                    ++longCharNum;
                } else {
                    ++shortCharNum;
                }

                int longNum = getLongCharNum(shortCharNum, longCharNum);
                if (startIndex <= longNum && longNum < endIndex) {
                    builder.append(ch);
                }
            }

            return builder.toString();
        }
    }

    private static int getLongCharNum(int shortCharNum, int longCharNum) {
        return (shortCharNum * 3 + longCharNum * 5) / 5;
    }

    public static String getWindowString(String str, Integer minSize, Integer maxSize) {
        if (isEmpty(str) || null == minSize && null == maxSize) {
            return str;
        } else if (null != minSize && null != maxSize && minSize > maxSize) {
            return "";
        } else {
            StringBuilder builder;
            int i;
            if (null == maxSize) {
                if (str.length() < minSize) {
                    builder = new StringBuilder();
                    builder.append(str);

                    for(i = 0; i < minSize - str.length(); ++i) {
                        builder.append(" ");
                    }

                    return builder.toString();
                }
            } else {
                if (str.length() > maxSize) {
                    return str.substring(0, maxSize);
                }

                if (null != minSize && str.length() < minSize) {
                    builder = new StringBuilder();
                    builder.append(str);

                    for(i = 0; i < minSize - str.length(); ++i) {
                        builder.append(" ");
                    }

                    return builder.toString();
                }
            }

            return str;
        }
    }

    public static boolean containsEnglishChar(String str) {
        if (isEmpty(str)) {
            return false;
        } else {
            for(int i = 0; i < str.length(); ++i) {
                if (isEnglishChar(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isNumberChar(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static boolean isEnglishChar(char ch) {
        return isUpperCaseChar(ch) || isLowerCaseChar(ch);
    }

    public static boolean isUpperCaseChar(char ch) {
        return 'A' <= ch && ch <= 'Z';
    }

    public static boolean isLowerCaseChar(char ch) {
        return 'a' <= ch && ch <= 'z';
    }

    public static List<String> split(List<String> strList, String separator, boolean saveSeparator) {
        if (CollectionUtil.isEmpty(strList)) {
            return Collections.EMPTY_LIST;
        } else {
            List<String> itemList = new ArrayList();
            Iterator var4 = strList.iterator();

            while(var4.hasNext()) {
                String itemStr = (String)var4.next();
                if (null != itemStr && !"".equals(itemStr)) {
                    itemList.addAll(split(itemStr, separator, saveSeparator));
                }
            }

            return itemList;
        }
    }

    public static List<String> split(String str, String separator, boolean saveSeparator) {
        if (isEmpty(str)) {
            return Collections.EMPTY_LIST;
        } else {
            List<String> itemList = new ArrayList();
            char separatorFirtChar = separator.charAt(0);
            int preSegmentStartIndex = 0;

            for(int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                if (ch == separatorFirtChar) {
                    int j;
                    for(j = 1; j < separator.length() && i + j < str.length() && separator.charAt(j) == str.charAt(i + j); ++j) {
                    }

                    if (j >= separator.length()) {
                        if (preSegmentStartIndex < i) {
                            itemList.add(str.substring(preSegmentStartIndex, i));
                        }

                        if (saveSeparator) {
                            itemList.add(separator);
                        }

                        preSegmentStartIndex = i + j;
                        i = i + j - 1;
                    }
                }
            }

            if (preSegmentStartIndex < str.length()) {
                itemList.add(str.substring(preSegmentStartIndex, str.length()));
            }

            return itemList;
        }
    }

    public static String replaceAll(String sourceStr, String anchorStr, String replaceStr) {
        if (null != sourceStr && null != anchorStr && null != replaceStr) {
            if (anchorStr.length() > sourceStr.length()) {
                return sourceStr;
            } else {
                char anchorFirtChar = anchorStr.charAt(0);
                StringBuilder builder = new StringBuilder();

                for(int i = 0; i < sourceStr.length(); ++i) {
                    char ch = sourceStr.charAt(i);
                    if (ch != anchorFirtChar) {
                        builder.append(ch);
                    } else {
                        boolean isMatched = true;
                        int j = i;

                        for(int k = 0; k < anchorStr.length(); ++k) {
                            j = i + k;
                            if (j >= sourceStr.length() || sourceStr.charAt(j) != anchorStr.charAt(k)) {
                                isMatched = false;
                            }
                        }

                        if (isMatched) {
                            builder.append(replaceStr);
                            i = j;
                        } else {
                            builder.append(ch);
                        }
                    }
                }

                return builder.toString();
            }
        } else {
            return sourceStr;
        }
    }

    public static String nullParser(String str) {
        return str == null ? "" : str;
    }

    public static String toLowerCase(String str) {
        return isEmpty(str) ? str : str.toLowerCase();
    }

    public static String toTrimAndLowerCase(String str) {
        return null == str ? null : str.trim().toLowerCase();
    }

    public static boolean equals(String str1, String str2) {
        return null != str1 && null != str2 ? str1.equals(str2) : false;
    }

    public static boolean isMobileNumber(String keyword) {
        return null != keyword && keyword.matches("^1[0-9]{10}$");
    }

    public static List<String> spiltToString(String str, String separator) throws RuntimeException {
        return spiltToString(str, separator, true);
    }

    public static List<String> spiltToString(String str, String separator, boolean isDirect) throws RuntimeException {
        if (isEmpty(str)) {
            throw new RuntimeException("str is empty.");
        } else {
            List<String> l = new ArrayList();
            if (null == separator) {
                l.add(str);
                return l;
            } else if (isDirect) {
                List<String> splittedList = split(str, separator, false);
                Iterator var10 = splittedList.iterator();

                while(var10.hasNext()) {
                    String numStr = (String)var10.next();
                    if (!isEmpty(numStr)) {
                        l.add(numStr);
                    }
                }

                return l;
            } else {
                String[] splitArray = str.trim().split(separator);
                String[] var5 = splitArray;
                int var6 = splitArray.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String numStr = var5[var7];
                    if (!isEmpty(numStr)) {
                        l.add(numStr);
                    }
                }

                return l;
            }
        }
    }

    public static String[] spiltToStringArray(String str, String separator) throws RuntimeException {
        if (null == str) {
            throw new RuntimeException("str is null.");
        } else {
            String[] splitArray = str.trim().split(separator);
            return splitArray;
        }
    }

    public static List<Long> spiltToLong(String str, String separator) throws RuntimeException {
        return spiltToLong(str, separator, true);
    }

    public static List<Long> spiltToLong(String str, String separator, boolean isDirect) throws RuntimeException {
        if (isEmpty(str)) {
            throw new RuntimeException("str is empty.");
        } else {
            List<Long> l = new ArrayList();
            if (null == separator) {
                l.add(Long.parseLong(str));
                return l;
            } else if (isDirect) {
                List<String> splittedList = split(str, separator, false);
                Iterator var10 = splittedList.iterator();

                while(var10.hasNext()) {
                    String numStr = (String)var10.next();
                    if (!isEmpty(numStr)) {
                        l.add(Long.parseLong(numStr.trim()));
                    }
                }

                return l;
            } else {
                String[] splitArray = str.trim().split(separator);
                String[] var5 = splitArray;
                int var6 = splitArray.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String numStr = var5[var7];
                    if (!isEmpty(numStr)) {
                        l.add(Long.parseLong(numStr.trim()));
                    }
                }

                return l;
            }
        }
    }

    public static List<Integer> spiltToInteger(String str, String separator) throws RuntimeException {
        return spiltToInteger(str, separator, true);
    }

    public static List<Integer> spiltToInteger(String str, String separator, boolean isDirect) throws RuntimeException {
        if (isEmpty(str)) {
            throw new RuntimeException("str is empty.");
        } else {
            List<Integer> l = new ArrayList();
            if (null == separator) {
                l.add(Integer.parseInt(str));
                return l;
            } else if (isDirect) {
                List<String> splittedList = split(str, separator, false);
                Iterator var10 = splittedList.iterator();

                while(var10.hasNext()) {
                    String numStr = (String)var10.next();
                    if (!isEmpty(numStr)) {
                        l.add(Integer.parseInt(numStr.trim()));
                    }
                }

                return l;
            } else {
                String[] splitArray = str.trim().split(separator);
                String[] var5 = splitArray;
                int var6 = splitArray.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String numStr = var5[var7];
                    if (!isEmpty(numStr)) {
                        l.add(Integer.parseInt(numStr.trim()));
                    }
                }

                return l;
            }
        }
    }

    public static List<Double> spiltToDouble(String str, String separator) throws RuntimeException {
        return spiltToDouble(str, separator, true);
    }

    public static List<Double> spiltToDouble(String str, String separator, boolean isDirect) throws RuntimeException {
        if (isEmpty(str)) {
            throw new RuntimeException("str is empty.");
        } else {
            List<Double> l = new ArrayList();
            if (null == separator) {
                l.add(Double.parseDouble(str));
                return l;
            } else if (isDirect) {
                List<String> splittedList = split(str, separator, false);
                Iterator var10 = splittedList.iterator();

                while(var10.hasNext()) {
                    String numStr = (String)var10.next();
                    if (!isEmpty(numStr)) {
                        l.add(Double.parseDouble(numStr.trim()));
                    }
                }

                return l;
            } else {
                String[] splitArray = str.trim().split(separator);
                String[] var5 = splitArray;
                int var6 = splitArray.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String numStr = var5[var7];
                    if (!isEmpty(numStr)) {
                        l.add(Double.parseDouble(numStr.trim()));
                    }
                }

                return l;
            }
        }
    }

    public static boolean isEmpty(String string) {
        return null == string || "".equals(string.trim());
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isTrimEmpty(String str) {
        return isEmpty(trim(str));
    }

    public static boolean isNotTrimEmpty(String str) {
        return !isTrimEmpty(str);
    }

    public static Map<String, String> splitToMap(String str, String mainSeparator, String subSeparator) throws Exception {
        if (isEmpty(str)) {
            return new HashMap();
        } else {
            String[] strArray = str.trim().split(mainSeparator);
            Map<String, String> map = new HashMap(strArray.length);
            String[] var5 = strArray;
            int var6 = strArray.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String kv = var5[var7];
                String[] kvArray = kv.trim().split(subSeparator);
                if (kvArray.length != 2 || isEmpty(kvArray[0]) || isEmpty(kvArray[1])) {
                    throw new Exception("the format of str is error, error: \"" + kv + "\" in " + str);
                }

                map.put(kvArray[0], kvArray[1]);
            }

            return map;
        }
    }

    public static String toListStatement(String pre, List<?> list, String splitTag, String end) {
        if (null != list && 0 < list.size() && null != splitTag) {
            pre = null == pre ? "" : pre;
            end = null == end ? "" : end;
            StringBuilder builder = new StringBuilder();
            builder.append(pre);
            boolean isFirst = true;

            Object obj;
            for(Iterator var6 = list.iterator(); var6.hasNext(); builder.append(obj)) {
                obj = var6.next();
                if (isFirst) {
                    isFirst = false;
                } else {
                    builder.append(splitTag);
                }
            }

            builder.append(end);
            return builder.toString();
        } else {
            return null;
        }
    }

    public static String toSetStatement(String pre, Set<?> set, String splitTag, String end) {
        if (null != set && 0 < set.size() && null != splitTag) {
            pre = null == pre ? "" : pre;
            end = null == end ? "" : end;
            StringBuilder builder = new StringBuilder();
            builder.append(pre);
            boolean isFirst = true;

            Object obj;
            for(Iterator var6 = set.iterator(); var6.hasNext(); builder.append(obj)) {
                obj = var6.next();
                if (isFirst) {
                    isFirst = false;
                } else {
                    builder.append(splitTag);
                }
            }

            builder.append(end);
            return builder.toString();
        } else {
            return null;
        }
    }

    public static List<String> toList(String str, String splitChar) {
        if (isEmpty(str)) {
            return null;
        } else {
            String[] array = str.split(splitChar);
            List<String> list = new ArrayList(array.length);
            list.addAll(Arrays.asList(array));
            return list;
        }
    }

    public static String toRangeStr(String str, String splitChar) {
        if (isEmpty(str)) {
            return null;
        } else {
            String[] array = str.split(splitChar);
            return "[" + array[0] + " " + array[1] + "]";
        }
    }

    public static String toRangeStr(Object val1, String splitChar, Object val2) {
        if (null != val1 && null != val2) {
            String str1 = null == val1 ? "" : val1 + "";
            String str2 = null == val2 ? "" : val2 + "";
            return str1 + splitChar + str2;
        } else {
            return null;
        }
    }

    public static String join(String splitStr, String... strArray) {
        if (null != splitStr && null != strArray) {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            String[] var4 = strArray;
            int var5 = strArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String obj = var4[var6];
                if (null != obj) {
                    if (!first) {
                        builder.append(splitStr);
                    } else {
                        first = false;
                    }

                    builder.append(obj);
                }
            }

            return builder.toString();
        } else {
            return null;
        }
    }

    public static String join(String splitStr, List<String> stringList) {
        if (null != splitStr && null != stringList) {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            Iterator var4 = stringList.iterator();

            while(var4.hasNext()) {
                String obj = (String)var4.next();
                if (null != obj) {
                    if (!first) {
                        builder.append(splitStr);
                    } else {
                        first = false;
                    }

                    builder.append(obj);
                }
            }

            return builder.toString();
        } else {
            return null;
        }
    }

    public static List<Integer> strIndexToIntList(String str, char indexStr) throws Exception {
        if (null == str) {
            return Collections.EMPTY_LIST;
        } else {
            List<Integer> list = new ArrayList();

            for(int i = 0; i < str.length(); ++i) {
                if (indexStr == str.charAt(i)) {
                    list.add(i);
                }
            }

            return list;
        }
    }

    public static String trim(String str) {
        if (null == str) {
            return null;
        } else {
            char[] tags = new char[]{'\n', '\t'};
            str = str.trim();
            int startIndex = 0;
            int endIndex = str.length();

            int i;
            char ch;
            for(i = 0; i < str.length(); ++i) {
                ch = str.charAt(i);
                if (!inCharSet(tags, ch)) {
                    startIndex = i;
                    break;
                }
            }

            for(i = str.length() - 1; i >= 0; --i) {
                ch = str.charAt(i);
                if (!inCharSet(tags, ch)) {
                    endIndex = i + 1;
                    break;
                }
            }

            return str.substring(startIndex, endIndex);
        }
    }

    private static boolean inCharSet(char[] array, char ch) {
        char[] var2 = array;
        int var3 = array.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char item = var2[var4];
            if (item == ch) {
                return true;
            }
        }

        return false;
    }

    public static String trim(String str, String tag) {
        if (null == str) {
            return null;
        } else if (str.equals(tag)) {
            return "";
        } else {
            int indexStart = 0;
            int indexEnd = str.length();
            if (str.startsWith(tag)) {
                indexStart = tag.length();
            }

            if (str.endsWith(tag)) {
                indexEnd = str.length() - tag.length();
            }

            if (indexEnd >= indexStart) {
                str = str.substring(indexStart, indexEnd);
            }

            return str;
        }
    }

    public static String limit(String str, int length) {
        return str.length() <= length ? str : str.substring(0, length - 1);
    }

    public static boolean startWith(String str, String startTag) {
        if (!isEmpty(str) && !isEmpty(startTag) && startTag.length() <= str.length()) {
            for(int i = 0; i < startTag.length(); ++i) {
                if (startTag.charAt(i) != str.charAt(i)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean endsWith(String str, String endTag) {
        if (!isEmpty(str) && !isEmpty(endTag) && endTag.length() <= str.length()) {
            int strIndex = str.length() - 1;

            for(int i = endTag.length() - 1; i >= 0; --strIndex) {
                if (endTag.charAt(i) != str.charAt(strIndex)) {
                    return false;
                }

                --i;
            }

            return true;
        } else {
            return false;
        }
    }

    public static String underlineToHump(String underline) {
        if (null == underline) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            boolean needToUpper = false;

            for(int i = 0; i < underline.length(); ++i) {
                char ch = underline.charAt(i);
                if ('_' == ch) {
                    needToUpper = true;
                } else if (needToUpper) {
                    String str = ch + "";
                    builder.append(str.toUpperCase());
                    needToUpper = false;
                } else {
                    builder.append(ch);
                }
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(isMobileNumber("135123445613423424"));
        System.out.println(underlineToHump("_a_1_A_b_asd"));
    }
}
