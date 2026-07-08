function ListofPlayers() {
  const players = [
    { name: 'Virat Kohli', score: 82 },
    { name: 'Rohit Sharma', score: 76 },
    { name: 'Shubman Gill', score: 68 },
    { name: 'KL Rahul', score: 71 },
    { name: 'Hardik Pandya', score: 64 },
    { name: 'Suryakumar Yadav', score: 88 },
    { name: 'Ravindra Jadeja', score: 59 },
    { name: 'Rishabh Pant', score: 73 },
    { name: 'Jasprit Bumrah', score: 61 },
    { name: 'Mohammed Shami', score: 79 },
    { name: 'Axar Patel', score: 67 }
  ];

  const playerCards = players.map((player, index) => (
    <li key={player.name} className="item-card">
      <strong>{index + 1}. {player.name}</strong>
      <span>Score: {player.score}</span>
    </li>
  ));

  const belowSeventy = players.filter((player) => player.score < 70);

  return (
    <section className="section-block">
      <h2>List of Players</h2>
      <h3>All Players Using map()</h3>
      <ul className="grid-list">{playerCards}</ul>

      <h3>Players Below 70</h3>
      <ul className="grid-list">
        {belowSeventy.map((player) => (
          <li key={player.name} className="item-card item-card-muted">
            <strong>{player.name}</strong>
            <span>Score: {player.score}</span>
          </li>
        ))}
      </ul>
    </section>
  );
}

export default ListofPlayers;
