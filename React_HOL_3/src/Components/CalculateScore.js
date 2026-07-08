function CalculateScore({ name, school, total, goal }) {
  const averageScore = total / goal;

  return (
    <div className="score-panel">
      <p><span>Name:</span> {name}</p>
      <p><span>School:</span> {school}</p>
      <p><span>Total:</span> {total}</p>
      <p><span>Goal:</span> {goal}</p>
      <p className="highlight"><span>Average Score:</span> {averageScore.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
