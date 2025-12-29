class Solution {
    HashSet<String> bad = new HashSet<>();
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return findNewLevel(0, bottom, "");
    }

    public boolean findNewLevel(int i, String currentLevel, String newLevel) {
        if (currentLevel.length() == 1) return true;


        String state = i + ":" + currentLevel + ":" + newLevel;
        if (bad.contains(state)) return false;

        if (i == currentLevel.length() - 1) {
            return findNewLevel(0, newLevel, "");
        }

        String prefix = currentLevel.substring(i, i + 2);

        if (map.containsKey(prefix)) {
            for (char candidate : map.get(prefix)) {
                if (findNewLevel(i + 1, currentLevel, newLevel + candidate)) {
                    return true;
                }
            }
        }

        bad.add(state);
        return false;
    }
}