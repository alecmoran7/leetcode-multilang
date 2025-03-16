import (
    "fmt"
    "sort"
    "slices"
)

func getSortedString(stringToSort string) string{
        runeArray := []rune(stringToSort)
        sort.Slice(runeArray, func(j, k int) bool {
            return runeArray[j] < runeArray[k]
        })
        return string(runeArray)
}

func groupAnagrams(strs []string) [][]string {
    // fmt.Println("strs: ", strs)
    var answerArray = make([][]string, 0)
    var indicesToSkip = make([]int, 0)
        for i := 0; i < len(strs); i++ {
            if slices.Contains(indicesToSkip, i) {
                // fmt.Println("SKIPPING ", strs[i])
                continue // skip adding strings that have already been assigned to a group
            }
            if i == len(strs) - 1 {
                newArray := make([]string, 0)
                newArray = append(newArray, strs[i])
                answerArray = append(answerArray, newArray)
                break
            }
            var stringMatch = getSortedString(strs[i])
            newArray := make([]string, 0)
            newArray = append(newArray, strs[i])
            for j:= i + 1; j < len(strs); j++ {
                if stringMatch == getSortedString(strs[j]){
                    newArray = append(newArray, strs[j])
                    indicesToSkip = append(indicesToSkip, j)
                }
            }
            answerArray = append(answerArray, newArray)
        }
    return answerArray
}
