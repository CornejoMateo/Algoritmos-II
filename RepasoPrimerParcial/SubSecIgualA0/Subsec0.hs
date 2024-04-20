subsec :: [Int] -> Bool
subsec [] = False
subsec xs = aux xs 0

aux :: [Int] -> Int -> Bool
aux [] _ = False
aux [x] c = if(x + c == 0) then True else False
aux (x:xs) n = x == 0 || aux xs n || aux xs (n+x)