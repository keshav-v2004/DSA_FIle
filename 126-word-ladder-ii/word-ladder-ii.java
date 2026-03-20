class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        answer = new ArrayList<>();

        Set<String> allWords = new HashSet<>(wordList);
        if (!allWords.contains(endWord)) return answer;

        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty()) {

            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String currentWord = q.poll();
                StringBuilder current = new StringBuilder(currentWord);

                for (int i = 0; i < current.length(); i++) {

                    char original = current.charAt(i);

                    for (int j = 0; j < 26; j++) {

                        char ch = (char) (j + 'a');
                        current.setCharAt(i, ch);

                        String newWord = current.toString();

                        if (newWord.equals(currentWord)) continue;

                        if (allWords.contains(newWord) && !visited.contains(newWord)) {

                            if (!levelVisited.contains(newWord)) {
                                q.offer(newWord);
                                levelVisited.add(newWord);
                            }

                            map.putIfAbsent(newWord, new ArrayList<>());
                            map.get(newWord).add(currentWord);

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    current.setCharAt(i, original); // restore
                }
            }

            visited.addAll(levelVisited);

            if (found) break;
        }

        if (found) {
            helper(endWord, beginWord, map, new ArrayList<>());
        }

        return answer;
    }

    public void helper(
            String word, String beginWord,
            Map<String, List<String>> map,
            ArrayList<String> sequence
    ) {

        sequence.add(word);

        if (word.equals(beginWord)) {
            Collections.reverse(sequence);
            answer.add(new ArrayList<>(sequence));
            Collections.reverse(sequence);
        } else {
            if (map.containsKey(word)) {
                for (String parent : map.get(word)) {
                    helper(parent, beginWord, map, sequence);
                }
            }
        }

        sequence.remove(sequence.size() - 1);
    }
}