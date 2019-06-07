/* #78 Subsets */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null){            
            return res;
        }       
        res.add(new ArrayList<Integer>(){});
        dfs(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, int start, List<Integer> subset){
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);            
            dfs(res, nums, i+1, subset);
            res.add(new ArrayList<>(subset));
            subset.remove(subset.size()-1);
        }
    }
}

/************************************************************************/

/* #90 Subsets II */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>(){});
        if(nums == null || nums.length == 0){
            return res;
        }
        dfs(res, 0, nums, new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int start, int[] nums, List<Integer> subset){
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            dfs(res, i+1, nums, subset);
            res.add(new ArrayList<Integer>(subset));
            subset.remove(subset.size()-1);
        }
    }
}

/************************************************************************/

/* #46 Permutations */
//一开始没想太明白，把for循环写在dfs的最外层了
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> subset){           
            if(subset.size() == nums.length){
                res.add(new ArrayList<Integer>(subset));                
            }else{
                for(int i = 0; i < nums.length; i++){   
                    if(subset.contains(nums[i])){
                       continue; 
                    }
                    subset.add(nums[i]);
                    dfs(res, nums, subset);
                    subset.remove(subset.size()-1);
                }
        }
    }
}

/************************************************************************/

/* #131 Palindrome Partitioning */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, s, 0, new ArrayList<String>());
        return res;
    }
    //backtracking这块还是不是特别明白，自己写就容易乱
    public void dfs(List<List<String>> res, String s, int start, List<String> substring){
        if(start >= s.length() && substring.size() > 0){
            res.add(new ArrayList<>(substring));
        }else{
            for(int i = start; i < s.length(); i++){                
                
                if(isPalindrome(s, start, i)){
                    substring.add(s.substring(start, i+1));         
                    dfs(res, s, i+1, substring);
                    substring.remove(substring.size()-1); 
                }                              
            }
        }        
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            while(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}