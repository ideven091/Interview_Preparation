def arrayOfProducts(array):
    # Write your code here.
    output = array[:]
    """
    Map<Integer,Integer>
    map.put(i,
    3,2->1*2,1*3
    2,3,4->1*3*4,2*1*4,2*3*1
    """
    n = len(array)

    left=1;right=1
    for i in range(n):
        output[i]=left
        left*=array[i]
    print(output)
    for i in reversed(range(n)):
        output[i]*=right
        right*=array[i]
        print(output)
    return output

print(arrayOfProducts(list(range(1,6))))


