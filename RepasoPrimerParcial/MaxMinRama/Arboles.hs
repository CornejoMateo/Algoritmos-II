data Tree int = Nil | Node (Tree Int) Int (Tree Int)         deriving Show


camino :: Eq a => Tree a -> Int -> Bool
camino Nil n = False
camino (Node Nil a Nil) n = if (a == n) then True else False
camino (Node a1 a Nil) n = camino a1 (n-a)
camino (Node Nil a a2) n = camino a2 (n-a)
camino (Node a1 a a2) n = camino a1 (n-a) || camino a2 (n-a)