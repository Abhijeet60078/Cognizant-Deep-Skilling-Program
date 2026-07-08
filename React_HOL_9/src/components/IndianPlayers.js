function IndianPlayers() {
  const playerNames = ['Virat', 'Rohit', 'Shubman', 'KL', 'Hardik', 'Jadeja'];
  const [oddTeamPlayer1, oddTeamPlayer2, oddTeamPlayer3] = playerNames;
  const [, evenTeamPlayer1, , evenTeamPlayer2, , evenTeamPlayer3] = playerNames;

  const T20players = ['Rohit', 'Virat', 'Surya'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane', 'Saha'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <section className="section-block">
      <h2>Indian Players</h2>

      <h3>Odd Team Players</h3>
      <p>{oddTeamPlayer1}, {oddTeamPlayer2}, {oddTeamPlayer3}</p>

      <h3>Even Team Players</h3>
      <p>{evenTeamPlayer1}, {evenTeamPlayer2}, {evenTeamPlayer3}</p>

      <h3>Merged Players</h3>
      <ul className="inline-list">
        {mergedPlayers.map((player) => (
          <li key={player}>{player}</li>
        ))}
      </ul>
    </section>
  );
}

export default IndianPlayers;
