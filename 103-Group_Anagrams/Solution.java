class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> firstSet = new ArrayList<String>();
        firstSet.add(strs[0]);
        List<List<String>> answerList = new ArrayList<List<String>>();
        answerList.add(firstSet);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < answerList.size(); j++) {
                char[] nextStringSorted = strs[i].toCharArray();
                char[] stringInListSorted = answerList.get(j).get(0).toCharArray();
                Arrays.sort(nextStringSorted);
                Arrays.sort(stringInListSorted);
                if (Arrays.equals(nextStringSorted, stringInListSorted)) {
                    answerList.get(j).add(strs[i]);
                    break;
                }
                if (j == answerList.size() - 1){
                    ArrayList newGroup = new ArrayList<String>();
                    newGroup.add(strs[i]);
                    answerList.add(newGroup);
                    break;
                }
            }
        }
        return answerList;
    }
}
