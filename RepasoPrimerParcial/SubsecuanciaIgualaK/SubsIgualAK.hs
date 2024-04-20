sub :: Eq a => [a] -> [a] -> Int -> Bool
sub xs (y:ys) 0 = False
sub (x:xs) [] 0 = False
sub xs [] k = if(length xs > k) then False else True
sub (x:xs) ys k 
    | elem x ys = sub xs (remove ys x) k
    | otherwise = sub xs ys (k-1)

remove :: Eq a => [a] -> a -> [a]
remove [] y = []
remove (x:xs) y = if(x == y) then xs else x : remove xs y