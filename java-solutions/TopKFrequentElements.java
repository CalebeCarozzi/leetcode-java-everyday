import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        //COM LAZY INITIALIZATION

        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if(bucket[i] != null){
                for (int num : bucket[i]) {
                    result[index] = num;
                    index++;
                    if (index == k) {
                        return result;
                    }
                }
            }

        }
        return result;
    }



    //RESOLUÇÃO COM ARRAY LIST, SEM LAZY INITIALIZATION
    //DESVANTAGEM -> tem que inicializar toda os arrayslist antes
    //porque não tem nulo como o array normal da resolução de cima

//        int[] result = new int[k];
//
//        List<List<Integer>> bucket = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        for (int i = 0; i <= nums.length; i++) {
//            bucket.add(new ArrayList<>());
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            bucket.get(entry.getValue()).add(entry.getKey());
//        }
//
//        int index = 0;
//        for (int i = (bucket.size()) - 1; i >= 0; i--) {
//            for(Integer num : bucket.get(i)){
//                result[index] = num;
//                k--;
//                index++;
//
//                if (k == 0) {
//                    return result;
//                }
//            }
//        }
//
//        return result;
//    }

}





