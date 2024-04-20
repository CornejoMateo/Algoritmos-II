cent :: [Int] -> Int -> Int
cent [] c = 0
cent (x:xs) c 
    | x == c = 1
    | x < c = cent (x:xs) (c-x) + cent xs c
    | otherwise = cent xs c