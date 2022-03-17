with Ada.Text_IO; 
use Ada.Text_IO;
procedure JumpFrog is
 alturaSalto : Integer := 2; -- Altura do salto
 quantidadeTubos : Integer := 3; -- Quantidade de tubos
 Index: Integer := 1;
 type Arr is array (Integer range<>) of Integer;
 alturasTubos : Arr := (1, 4, 2); -- Alturas dos tubos
 alturaEsquerda : Integer;
 alturaDireita : Integer;
 diferencaAltura : Integer;
 pulo : Integer;
 resultado : Integer := 1;
 begin
   loop
     exit when Index = quantidadeTubos;
     alturaEsquerda := alturasTubos(Integer'First + Index -1);
     alturaDireita := alturasTubos(Integer'First + Index);
     diferencaAltura := alturaEsquerda - alturaDireita;
     pulo := diferencaAltura + alturaSalto;
     if pulo < 0 then
       Put_Line ("VOCÊ PERDEU!");
       Index := quantidadeTubos;
       resultado := 0;
     end if;
     Index := Index + 1;
   end loop;
   if resultado > 0 then
     Put_Line("VOCÊ GANHOU !");
   end if;
end JumpFrog;