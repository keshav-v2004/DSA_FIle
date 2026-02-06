public class Codec {

    Map<Integer , String> map = new HashMap<>();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode() , longUrl);
        StringBuilder answer = new StringBuilder();

        answer.append("http://tinyurl.com/");
        answer.append(longUrl.hashCode());

        return  answer.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        int index = 19;
        StringBuilder hash = new StringBuilder();
        int n = shortUrl.length();

        while(index < n){
            char ch = shortUrl.charAt(index);
            hash.append(ch);
            index++;
        }

        String orig = map.get(Integer.parseInt(hash.toString()));
        return orig;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));