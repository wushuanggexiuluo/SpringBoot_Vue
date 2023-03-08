//     +    URL 中+号表示空格                                 %2B
// 空格 URL中的空格可以用+号或者编码           %20
// /   分隔目录和子目录                                     %2F
//     ?    分隔实际的URL和参数                             %3F
//     %    指定特殊字符                                          %25
// #    表示书签                                                  %23
// &    URL 中指定的参数间的分隔符                  %26
//     =    URL 中指定参数的值                                %3D
export default function CharsetFilter(str) {

    if (str != null) {
        if (str.indexOf('%') >= 1){
            str = str.replace("%", "rtfgv")
        }
        if (str.indexOf('#') >= 1) {
            str = str.replace("#", "%23")
        }
        if (str.indexOf('+') >= 1) {
            str = str.replace("+", "%2B")
        }
        if (str.indexOf('?') >= 1) {
            str = str.replace("?", "%2F")
        }
        if (str.indexOf('&') >= 1) {
            str = str.replace("&", "%26")
        }
        if (str.indexOf('=') >= 1) {
            str = str.replace("=", "%3D")
        }

    }
    return str
}
