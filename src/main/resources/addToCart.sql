# Skapa också en stored procedure 'AddToCart'.
#     Denna procedur skall ta kundid, beställningsid och produktid som inparametrar.
#     (Beroende på hur din implementation ser ut kan du behöva använda andra värden som inparametrar,
#     justera i så fall parameterlistan för att kunna peka ut en produkt, kund och beställning.)
# AddToCart ska fungera på följande sätt:
# Om beställningen, vars id vi skickar in som inparameter,
#     inte finns eller om vi skickar in null som beställningsid ska en ny beställning skapas och produkten,
#     vars id vi skickat in som inparameter, läggas till i den.
# Om beställningen redan finns ska produkten läggas till i beställningen.
# Om beställningen finns och produkten redan finns i den ska vi lägga till ytterligare ett exemplar av produkten i beställningen.
# För varje produkt som blir tillagd i en beställning ska lagerantalet av produkten minska.


DELIMITER //
CREATE PROCEDURE AddToCart(IN kid INT, IN best_id VARCHAR(16), IN p_id INT)
BEGIN

    IF (best_id IS NULL) THEN
BEGIN
select count(beställningsId) into @sist from beställning where kundId = kid group by beställningsId;
IF @sist is null Then
                SET @sist = 1;
else
                SET @sist = (select @sist + 1);
end if;
insert into beställning (beställningsId, produktId, kundId)
VALUES ((SELECT concat(LPAD(kid, 3, 0), LPAD(@sist, 3, 0))), p_id, kid);
END;
ELSE
BEGIN
insert into beställning (beställningsId, produktId, kundId) VALUES (best_id, p_id, kid);
END;
END IF;

SELECT l.antalIlager into @antal FROM lager l where l.produktId = p_id;
SELECT l.id into @id FROM lager l where l.produktId = p_id;

UPDATE lager t SET t.antalIlager = (select @antal - 1) WHERE t.id = @id;
END;
DELIMITER ;
