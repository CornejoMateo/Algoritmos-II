f :: [Int] -> [Int] -> Int
f [] _ = 0
f xs ys = sum xs - aux xs ys (length xs) 1

aux :: [Int] -> [Int] -> Int -> Int -> Int
aux [] [] n c = 0
aux (x:xs) (y:ys) n c = if(n == c) then 0 else if(y >= c) then max (x + aux xs ys n (c+1)) (aux xs ys n c) else aux xs ys n c