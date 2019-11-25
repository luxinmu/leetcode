package test;

import java.util.StringTokenizer;

public class T71_SimplifyPath {
    public static void main(String[] args) {
        T71_SimplifyPath t71 = new T71_SimplifyPath();
        System.out.println(t71.simplifyPath("/home/")); // -> /home
        System.out.println(t71.simplifyPath("/../"));   // -> /
        System.out.println(t71.simplifyPath("/..."));   // -> /...
        System.out.println(t71.simplifyPath("/./..."));   // -> /...
        System.out.println(t71.simplifyPath("/a/../.../a.."));   // -> /.../a..
        System.out.println(t71.simplifyPath("/a//b////c/d//././/..")); // -> /a/b/c
        System.out.println(t71.simplifyPath("/a/../../b/../c//.//"));  // -> /c
        System.out.println(t71.simplifyPath("/..hidden"));  // -> /..hidden
        System.out.println(t71.simplifyPath("/.hidden"));   // -> /.hidden
    }

    /**
     * StringTokenizer 效率高于 split
     */
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        char pathstack[] = new char[1024];
        int top = -1;
        String s;
        while (st.hasMoreTokens()) {
            s = st.nextToken();
            switch (s) {
                case ".":
                case "":
                    continue;
                case "..":
                    while (top >= 0)
                        if (pathstack[top--] == '/')
                            break;
                    break;
                default:
                    pathstack[++top] = '/';
                    for (int i = 0; i < s.length(); i++)
                        pathstack[++top] = s.charAt(i);
            }
        }
        return top == -1 ? "/" : new String(pathstack, 0, top + 1);
    }

    /**
     * 执行用时 :5 ms, 95.57%
     * 内存消耗 :36.3 MB, 98.80%
     */
    public String simplifyPath3(String path) {
        String paths[] = path.split("/");
        char pathstack[] = new char[1024];
        int top = -1;
        for (String s : paths)
            switch (s) {
                case ".":
                case "":
                    continue;
                case "..":
                    while (top >= 0)
                        if (pathstack[top--] == '/')
                            break;
                    break;
                default:
                    pathstack[++top] = '/';
                    for (int i = 0; i < s.length(); i++)
                        pathstack[++top] = s.charAt(i);
            }
        return top == -1 ? "/" : new String(pathstack, 0, top + 1);
    }

    /**
     * 执行用时 :2 ms, 99.96%
     * 内存消耗 :36.7 MB, 96.39%
     */
    public String simplifyPath1(String path) {
        char pathstack[] = new char[1024];
        int top = 0;
        pathstack[0] = '/';
        int len = path.length();
        for (int i = 0; i < len; i++)
            if (path.charAt(i) == '/') {
                if (pathstack[top] != '/')
                    pathstack[++top] = path.charAt(i);
            } else if (path.charAt(i) == '.') {
                if (pathstack[top] == '/') {
                    if (i + 1 < len) {
                        if (path.charAt(i + 1) == '.') {
                            if (i + 2 >= len || path.charAt(i + 2) == '/') {
                                while (top > 0)
                                    if (pathstack[--top] == '/') break;
                                i += 2;
                            } else {
                                for (int j = 0; j < 3; j++)
                                    pathstack[++top] = path.charAt(i++);
                                i--;
                            }
                        } else if (path.charAt(i + 1) == '/') {
                            i++;
                        } else pathstack[++top] = path.charAt(i);
                    }
                } else pathstack[++top] = path.charAt(i);
            } else
                pathstack[++top] = path.charAt(i);
        if (top != 0 && pathstack[top] == '/')
            top--;
        return new String(pathstack, 0, top + 1);
    }

    /**
     * "/a/../.../a.." should "/.../a..", reality "/..."
     * 执行用时 :3 ms, 99.47%
     * 内存消耗 :35.9 MB, 99.40%
     */
    public String simplifyPathErr(String path) {
        char pathstack[] = new char[1024];
        int top = 0;
        pathstack[0] = '/';
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) == '/') {
                if (pathstack[top] != '/')
                    pathstack[++top] = path.charAt(i);
            } else if (path.charAt(i) == '.') {
                if (i + 1 < len) {
                    if (path.charAt(i + 1) == '.') {
                        if (i + 2 >= len || path.charAt(i + 2) == '/') {
                            while (top > 0)
                                if (pathstack[--top] == '/') break;
                        } else {
                            top++;
                            System.arraycopy(path.substring(i, i + 3).toCharArray(), 0, pathstack, top, 3);
                            top += 2;
                        }
                        i += 2;
                    } else if (path.charAt(i + 1) == '/') {
                        i++;
                    } else pathstack[++top] = path.charAt(i);
                }
            } else
                pathstack[++top] = path.charAt(i);
        }
        if (top != 0 && pathstack[top] == '/')
            top--;
        return new String(pathstack, 0, top + 1);
    }
}
