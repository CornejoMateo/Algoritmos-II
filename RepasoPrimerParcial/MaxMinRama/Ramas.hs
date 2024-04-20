data Tree a = Nil | Node (Tree a) a (Tree a)         deriving Show

ramas :: Tree a -> (Int, Int)
ramas Nil = (0, 0)
ramas (Node Nil a Nil) = (1, 1)
ramas (Node Nil a a2) = (1 + fst (ramas a2), 1 + snd (ramas a2))
ramas (Node a1 a Nil) = (1 + fst (ramas a1), 1 + snd (ramas a1))
ramas (Node a1 a a2) = (1 + max (fst a) (fst b ),  1 + min (snd a) (snd b))
                      where (a, b) = (ramas a1, ramas a2)